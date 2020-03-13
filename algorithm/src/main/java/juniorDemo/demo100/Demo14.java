package juniorDemo.demo100;

import org.junit.Test;

//求一个数组中的最长公共前缀
public class Demo14 {

    @Test
    public String test1() {
        String[] str = {"saf","dsafs","trg"};
        String pre = str[0];
        for (int i = 0; i < str.length; i++) {
            while (str[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            if (pre.isEmpty()) {
                return "";
            }
        }
        return pre;
    }

    @Test
    public String test2() {

        String[] str = {"asdf", "sdfsdf", "dsfdsfds"};
        if (str == null || str.length == 0) {
            return "";
        }
        String pre = str[0];
        for (int i = 0; i < pre.length(); i++) {
            char c = pre.charAt(i);
            for (int j = 1; j < str.length; j++) {
                if (str[j].length() == i || str[j].charAt(i) != c) {
                    return pre.substring(0, i);
                }
            }
        }
        return pre;
    }

}
