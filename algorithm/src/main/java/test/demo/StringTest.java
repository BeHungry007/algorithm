package test.demo;

import org.junit.Test;

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
}
