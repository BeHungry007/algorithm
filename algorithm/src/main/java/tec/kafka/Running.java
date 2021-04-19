package tec.kafka;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Running {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "test15");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.9.217:9092");
        properties.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, 6);
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        KStreamTest kStreamTest = new KStreamTest();
        StreamsBuilder builder1 = new StreamsBuilder();
        Thread t = new Thread(kStreamTest, "KSTREAM");
        t.start();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss a");
        Date date = new Date();
        System.out.println("开始时间：" + simpleDateFormat.format(date));
        int i = KStreamTest.countCMeter.get() + KStreamTest.countEDataMp.get();
        try {
            Thread.sleep(30*1000);
        } catch (Throwable e) {
            System.out.println(e.toString());
        }
        while (i != KStreamTest.countCMeter.get() + KStreamTest.countEDataMp.get()) {
            i = KStreamTest.countCMeter.get() + KStreamTest.countEDataMp.get();
            try {
                Thread.sleep(30*1000);
            } catch (Throwable e) {
                System.out.println(e.toString());
            }
        }
        System.out.println(KStreamTest.countCMeter);
        System.out.println(KStreamTest.countEDataMp);
        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> kstream = builder.stream("mid.e_data_mp");
        kstream.to("mid.e_data_mp_new");
        date = new Date();
        System.out.println("结束时间：" + simpleDateFormat.format(date));

    }
}
