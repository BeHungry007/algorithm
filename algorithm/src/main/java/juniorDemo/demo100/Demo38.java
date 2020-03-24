package juniorDemo.demo100;

import org.junit.Test;

//「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
public class Demo38 {
    @Test
    public void test01(){
        String s = countAndSay(4);
        System.out.println(s);
    }
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            String s1 = st(s);
            s = s1;
        }
        return s;

    }
    public String st(String s) {
        String s1 = "";
        char c = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                s1 = s1 + count + c;
                c = s.charAt(i);
                count = 1;
            }
        }
        return s1 = s1 + count + c;
    }
}
