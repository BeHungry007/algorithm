package test.demo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class StringTest {

    @Test
    public void test01(){
        String s = "qwe  123 rewr   sdf";
        String[] split1 = s.split(" ");
        String[] split2 = s.split("\\s");
        System.out.println(split1.length);
        System.out.println(split2.length);
        System.out.println("a");
    }

    @Test
    public void test02(){
        Map<String, String> map = new HashMap<>();
        map.put(null , "aa");
        map.put("bb", null);
        map.put(null, null);
        System.out.println(map);
    }
}
