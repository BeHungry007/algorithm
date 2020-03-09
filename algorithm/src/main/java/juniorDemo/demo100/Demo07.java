package juniorDemo.demo100;

import com.sun.jdi.IntegerType;
import org.junit.Test;


/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Demo07 {
    
    @Test
    public void test1() {
        Integer i = -120;
        String s1 = i.toString();
        while (s1.endsWith("0")) {
            s1 = s1.substring(0, s1.length() - 1);
        }
        StringBuilder builder = new StringBuilder(s1.substring(1, s1.length()));
        char c = s1.charAt(0);
        StringBuilder reverse = builder.reverse();
        if(s1.charAt(0) <= '0' || s1.charAt(0) >= '9') {
           s1 = c + reverse.toString();
        } else {
            s1 = reverse.toString() + c;
        }
        System.out.println(Integer.parseInt(s1));

    }

    @Test
    public void test2() {

    }


}
