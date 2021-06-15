package tec.flink;

import com.google.gson.JsonObject;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class StreamWordCount {

    public static void main(String[] args) {
        //StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        //DataStreamSource<String> localhost = env.socketTextStream("localhost", 7777);
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("aa", "bb");
//        jsonObject.addProperty("bb", "bb");
//        jsonObject.addProperty("aa", "cc");
//        System.out.println(jsonObject.toString());
//        String s = "a\"a\"a";
//        String s1 = s.replaceAll("\"", "");
//        System.out.println(s1.toString());
//        s = "\"01\",\"\",\"\"";
//        //String s2 = s.replaceAll("\"", "");
//        System.out.println(s.toString());
//        String[] split = s.split(",");
//        System.out.println(split.toString());
//
//        AtomicInteger count = new AtomicInteger(0);
//        count.getAndIncrement();
//        System.out.println(count);
        String s = "abc";
        boolean bc = s.contains("bdc");
        System.out.println(bc);


    }
}
