package sort.greedyAlgorithm.junior;

import org.junit.Test;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。
 * 字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        Integer slen = 0;
        Integer tlen = t.length();

        for(Integer i = 0; i < tlen; i++) {
            if (t.charAt(i) == s.charAt(slen)) {
                slen++;
                if (slen == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test0(){
        String s = "";
        System.out.println(s.charAt(0));
    }
}
