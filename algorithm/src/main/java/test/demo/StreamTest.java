//package test.demo;
//
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.common.utils.Bytes;
//import org.apache.kafka.streams.KeyValue;
//import org.apache.kafka.streams.StreamsBuilder;
//import org.apache.kafka.streams.StreamsConfig;
//import org.apache.kafka.streams.kstream.*;
//import org.apache.kafka.streams.state.KeyValueStore;
//
//import java.util.Properties;
//
//public class StreamTest {
//
//    public static void main(String[] args) {
//        new ProducerRecord<>("aa", "bb", "cc");
//        //new ValueMapper<String, Iterable<String>>()
//        final String storeName = "test";
//        Properties properties = new Properties();
//        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.9.217:9092");
//        properties.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
//        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        String tables = "cm-dm-rco-cmmr-cmp-cc";
//        int i = 0;
//        StreamsBuilder builder = new StreamsBuilder();
//        KStream<String, String> stream = builder.<String, String>stream("E_MP_DAY_READ", "aa",//);
//        GlobalKTable<String, String> cmTable = builder.globalTable(tables, Materialized.<String, String, KeyValueStore<Bytes, byte[]>>as("cm_statesstore")
//                .withKeySerde(Serdes.String())
//                .withValueSerde(Serdes.String()));
//
//        KStream<String, String> join = stream.join(cmTable,
//                new KeyValueMapper<String, String, String>() {
//
//                    @Override
//                    public String apply(String key, String value) {
//                        return key;
//                    }
//                });
//
//
//
//
//
//
////        KStream<String, String> all = left.selectKey((key, value) -> value.split(",")[1]).join(right.selectKey((key, value) -> value.split(",")[0]), new ValueJoiner<String, String, String>() {
////                    @Override
////                    public String apply(String value1, String value2) {
////                        return value1 + "--" + value2;
////                    }
////                }, JoinWindows.of(30000));
//
//        //all.print(new Printed<String, String>());
//    }
//}
