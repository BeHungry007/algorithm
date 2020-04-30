package middleDemo.Demo100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 整数转罗马数字
 */
public class Demo012 {
    @Test
    public void test01(){

    }

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int idx = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(idx < 13) {
            while (num >= nums[idx]) {
                stringBuilder.append(romans[idx]);
                num = num - nums[idx];
            }
            idx++;
        }
        return stringBuilder.toString();
    }
}
