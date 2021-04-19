package test.demo;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.apache.kafka.common.serialization.Serdes.String;

public class KTableTest {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-purchase-analysis2");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.9.217:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, String().getClass());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        StreamsBuilder builder = new StreamsBuilder();

        KStream<String, String> stream1 = builder.<String, String>stream("source");

        KTable<String, String> cmTable = builder.table("test", Materialized.<String, String, KeyValueStore<Bytes, byte[]>>as("cm_statesstore")
                .withKeySerde(Serdes.String())
                .withValueSerde(Serdes.String()));

        KStream<String, String> join = stream1.join(cmTable, new ValueJoiner<String, String, String>() {
            @Override
            public String apply(String value1, String value2) {
                System.out.println("value1 is " + value1);
                System.out.println("value2 is " + value2);
                return value2;

            }
        });
        KStream<String, String> resultStream = join.flatMapValues(new ValueMapper<String, Iterable<String>>() {
            @Override
            public Iterable<String> apply(String value) {
                List<String> list = new ArrayList<>();
                list.add(value);
                return list;

            }
        });

        resultStream.to("end");

        KafkaStreams kafkaStreams = new KafkaStreams(builder.build(), props);
        kafkaStreams.start();

    }
}
