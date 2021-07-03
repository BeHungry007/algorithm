package sort.stack.middle;

import java.util.Stack;

/**
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。
 *
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class removeDuplicateLetters316 {

    /**
     * 题解：
     *      1. 先遍历s，将每个字符出现在str中最大index的位置记录在pos数组中；
     *      2. 使用stack栈来存放需要输出的数据；
     *      3. 遍历s:
     *          如果stack有该字符，直接continue;
     *          stack不为空 && stack最新的字符 大于 当前字符 && stack最新字符在后面的遍历中还会出现，弹出stack.pop();
     *          stack.add(s.charAt(i);
     *      4. 遍历取出stack的数据并且reserve,然后return。
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        int[] pos = new int[30];
        for(int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'] = i;
        }
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if (st.contains(s.charAt(i))) {
                continue;
            }
            while (st.size() > 0 && st.peek() > s.charAt(i) && pos[st.peek() - 'a'] > i) {
                st.pop();
            }
            st.add(s.charAt(i));
        }
        int len = st.size();
        char[] tmp = new char[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = st.pop();
        }
        StringBuilder ans=new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            ans.append(tmp[i]);
        }
        return ans.toString();
    }
}
