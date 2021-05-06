package sort.string.middle;

import org.junit.Test;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring3 {

    @Test
    public void test0(){
        String s = "tmmzuxt";
        String s1 = "aabaab!bb";
        lengthOfLongestSubstring(s1);
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = -1, len = s.length(), ans = 0;
        HashMap<Character, Integer> list = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!list.containsKey(s.charAt(i))) {
                right++;

            }
            if (list.containsKey(s.charAt(i)) && list.get(s.charAt(i)) < left) {
                right++;
            }else if (list.containsKey(s.charAt(i)) && list.get(s.charAt(i)) >= left) {
                if (list.get(s.charAt(i)) == right) {
                    left = i;
                    right = i;
                } else {
                    left = list.get(s.charAt(i)) + 1;
                    right = i;
                }
            }
            list.put(s.charAt(i), i);
            ans = Math.max(ans, right - left + 1);

        }
        return ans;
    }
}
