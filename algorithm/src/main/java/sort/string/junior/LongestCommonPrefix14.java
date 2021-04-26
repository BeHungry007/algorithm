package sort.string.junior;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length ; i++) {
            ans = getPublic(ans, strs[i]);
            if (ans.length() == 0) {
                return "";
            }
        }
        return ans;
    }

    public String getPublic(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        int count = Math.min(ch1.length, ch2.length);
        for (int i = 0; i < count; i++) {
            if (ch1[i] == ch2[i]) {
                continue;
            } else {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0,count);
    }
}
