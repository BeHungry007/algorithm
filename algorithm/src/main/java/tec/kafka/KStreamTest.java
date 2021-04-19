package tec.kafka;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import tec.kafka.serde.JsonObjectSerde;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class KStreamTest  implements Runnable{
    public static AtomicInteger countCMeter = new AtomicInteger(0);

    public static AtomicInteger countEDataMp = new AtomicInteger(0);
    private Topology topo;

    private static final Properties props = new Properties();

    public KStreamTest() {
        topo = KStreamTest.buildStockArchivesTopology();
    }

    public static KStream<String, JsonObject> streamFromOgg(StreamsBuilder builder, String topic) {
        return builder.stream(topic, Consumed.with(Serdes.String(), new JsonObjectSerde()))
                .mapValues((key, value) -> {
                    System.out.println(value);
                    return value;
                });
    }

    public static KStream<String, JsonObject>[] splitStream(KStream<String, JsonObject> stream, String checkKey) {
        return stream.branch((key, value) -> value.has(checkKey), ((key, value) -> true));
    }

    public static JsonObject mergeValues(JsonObject leftValue, JsonObject rightValue) {
        if (rightValue == null) {
            return leftValue;
        }
        for (Map.Entry<String, JsonElement> elementEntry : rightValue.entrySet()) {

            leftValue.add(elementEntry.getKey(), elementEntry.getValue());
        }
        return leftValue;
    }

    public static Topology buildStockArchivesTopology() {
        KStreamTest.props.put(StreamsConfig.APPLICATION_ID_CONFIG, "test15");
        KStreamTest.props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.9.217:9092");
        KStreamTest.props.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, 6);
        KStreamTest.props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        KStreamTest.props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, JsonObjectSerde.class.getName());

        final StreamsBuilder builder = new StreamsBuilder();

        KTable<String, JsonObject> cMeter = streamFromOgg(builder, "mid.c_meter")
                .peek((key, value) -> {
                    if (KStreamTest.countCMeter.get() == 99000) {
                        System.out.println("a");
                    }
                    if ("90000".equals(key))
                        System.out.println(value);
                    KStreamTest.countCMeter.getAndIncrement();
                    System.out.println("c_meter: " + KStreamTest.countCMeter);
                }).toTable();

//        KTable<String, JsonObject> cMeter = builder.table("mid.c_meter", Consumed.with(Serdes.String(), new JsonObjectSerde()))
//                .mapValues((key, value) -> {
//                    if ("90000".equals(key))
//                        System.out.println(value);
//                    KStreamTest.countCMeter = KStreamTest.countCMeter + 1;
//                    System.out.println("c_meter: " + KStreamTest.countCMeter);
//                    return value;
//                });

        KStream<String, JsonObject> eDataMp = streamFromOgg(builder, "mid.e_data_mp_new");

//        KTable<String, JsonObject> rCollObj = builder.table("mid.r_coll_obj", Consumed.with(Serdes.String(), new JsonObjectSerde()))
//                .mapValues((key, value) -> {
//                    if ("90000".equals(key))
//                        System.out.println(value);
//                    KStreamTest.countEDataMp = KStreamTest.countEDataMp + 1;
//                    System.out.println("collObj: " + KStreamTest.countEDataMp);
//                    return value;
//                });

        KTable<String, JsonObject> rCollObj = streamFromOgg(builder, "mid.r_coll_obj")
                .peek((key, value) -> {
                    if ("90000".equals(key))
                        System.out.println(value);
                    KStreamTest.countEDataMp.getAndIncrement();
                    System.out.println("collObj: " + KStreamTest.countEDataMp);
                }).toTable();

        KStream<String, JsonObject>[] kCmeter = splitStream(eDataMp.selectKey((key, value) -> value.get("METER_ID").getAsString())
                .leftJoin(cMeter, KStreamTest::mergeValues), "REF_METER_FLAG");

        kCmeter[0].peek((key, value) -> System.out.println("join cmeter:" + key + ":" + value));
        kCmeter[1].peek((key, value) -> System.out.println("not join cmeter:" + key + ":" + value));

        KStream<String, JsonObject>[] kRCollObj = splitStream(kCmeter[0].selectKey((key, value) -> value.get("COLL_OBJ_ID").getAsString())
                .leftJoin(rCollObj, KStreamTest::mergeValues), "CT_RATIO");

        kCmeter[1].to("c_meter_fail");
        kRCollObj[1].to("r_coll_obj_fail");
        kRCollObj[0].to("success");

        return builder.build();
    }


    @Override
    public void run() {
        KafkaStreams kafkaStreams = new KafkaStreams(topo, props);
        final CountDownLatch latch = new CountDownLatch(1);
        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook") {
            @Override
            public void run() {
                kafkaStreams.close();
                kafkaStreams.cleanUp();
                latch.countDown();
            }
        });

        try {
            kafkaStreams.start();
            latch.await();
        } catch (Throwable e) {
            System.out.println(e.toString());
            System.exit(1);
        }
        System.exit(0);
    }
}
