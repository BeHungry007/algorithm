package ImportantDemo;

import org.junit.Test;

public class Demo1071Junior {

    public static void main(String[] args) {

    }
    public String test1() {
        String str1 = "ABCABC";
        String str2 = "ABC";
        String s = "";
        if (str1.length() > str2.length()) {
            String s2 = str1;
            str1 = str2;
            str2 = s2;
        }
        for (int i = str1.length() ; i >= 0 ; i--) {
            s = str1.substring(0, i);
            if (str1.replaceAll(s, "").length() ==0 && str2.replaceAll(s, "").length() == 0) {
                return s;
            }
        }
        return "";
    }
    @Test
    public void test2() {
        String s = "as";
        s.replaceAll("a", "");
        System.out.println(s);
    }
}
