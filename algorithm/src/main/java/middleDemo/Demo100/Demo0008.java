package middleDemo.Demo100;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 字符串转换成整数
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 *      如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 *      假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 *      该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 *      注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 */
public class Demo0008 {

    @Test
    public void test01(){
        boolean digit = Character.isDigit('b');
        System.out.println(digit);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public int myAtoi1(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;

        //1. 去除前导空格
        int idx = 0;
        while (idx < length && chars[idx] == ' ') {
            idx++;
        }
        //2. 如果已经遍历完成(针对极端用例"   ")
        if (idx == length) return 0;
        boolean negative = false;
        if (chars[idx] == '-') {
            negative = true;
            idx++;
        } else if (chars[idx] == '+') {
            idx++;
        } else if (!Character.isDigit(chars[idx])) {
            return 0;
        }
        int ans = 0;
        while (idx < length && Character.isDigit(chars[idx])) {
            int digit = chars[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return negative ? -ans : ans;
    }
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int length = 0;
        if(str.charAt(0) == '-') {
            for (int i = 1; i < str.length(); i++) {
                boolean checkout = checkout(str.charAt(i));
                if (!checkout) {
                    length = i;
                    break;
                }
            }
        }
        for (int i = 0; i < str.length(); i++) {
            boolean checkout = checkout(str.charAt(i));
            if (!checkout) {
                length = i;
                break;
            }
        }
        String s = str.substring(0, length);
        return 0;
    }
    public boolean checkout(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        } else {
            return false;
        }
    }
}
