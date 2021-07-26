package juniorDemo.demo100;

import org.junit.Test;


/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Demo0007 {
    
    @Test
    public void test1() {
        Integer i = -121;
        System.out.println(i % 10);
        System.out.println(i / 10);

    }

    @Test
    public void test2() {
        Integer x = 123;
        Integer y = 0;
        if(x < 0 && x/10 == 0) {
            System.out.println(true);
        }
        while (x > y) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        if (x == y || x == y/10){
            System.out.println(true);
        }
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
            x = x / 10;
        }
        return rev;
    }


}
