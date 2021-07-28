package middleDemo.Demo100;

import org.junit.Test;

/**
 * 最长回文子串
 *
 *  给定一个字符串s，找到s中最长的回文子串。假设s的最大长度为1000
 */
public class Demo0005 {

    @Test
    public void test01(){
        System.out.println(longestPalindrome("abcgfgfcba"));
        System.out.println(longestPalindrome("abcdcba"));
    }

    public String longestPalindrome(String s) {
        if (s.equals("")) return "";
        String origin = s;
        String reverse = new StringBuilder(s).reverse().toString();
        int[][] arr = new int[s.length()][s.length()];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    int beforeRev = s.length() - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) {
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    public String longestPalindrome2(String s) {
        if (s.equals("")) return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] arr = new int[length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0 ; j--) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if(i == 0|| j == 0) {
                        arr[j] = 1;
                    } else {
                        arr[j] = arr[j - 1] + 1;
                    }
                } else {
                    arr[j] = 0;
                }
                if (arr[j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[j] - 1 == i) {
                        maxLen = arr[j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    public String longestPalindrome3(String s) {
        if (s == null && s.length() == 0) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}





