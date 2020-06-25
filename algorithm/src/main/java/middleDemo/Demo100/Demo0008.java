package middleDemo.Demo100;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 字符串转换成整数
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
        int idx = 0;
        while (idx < length && chars[idx] == ' ') {
            idx++;
        }
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

    public int myAtoi2(String str) {
        char[] chars = str.toCharArray();
        int length = chars.length;
        int idx = 0;
        while (idx < length && chars[idx] == ' ') {
            idx++;
        }
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
}
