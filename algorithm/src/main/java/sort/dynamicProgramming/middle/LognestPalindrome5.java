package sort.dynamicProgramming.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串s，找到s中最长的回文子串
 */
public class LognestPalindrome5 {

    public String LognestPalindrome(String s) {
        if (s == null || "".equals(s)) return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = palindrome(s, i, i);
            int len2 = palindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int palindrome(String s, int i, int j) {
        int left = i, right = j;
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
public static void main(String[] args) {
    Set<String> set = new HashSet<>();
    set.add("e");
    set.add("a");
    set.add("b");
}
}
