package sort.stack.middle;

import java.util.Stack;

/**
 * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。
 *
 * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class removeDuplicateLetters316 {

    public String removeDuplicateLetters(String s) {
        int[] pos = new int[30];
        for(int i = 0; i < s.length(); i++) pos[s.charAt(i) - 'a'] = i;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if (st.contains(s.charAt(i))) continue;
            while (st.size() > 0 && st.peek() > s.charAt(i) && pos[st.peek() - 'a'] > i) st.pop();
            st.add(s.charAt(i));
        }
        int len = st.size();
        char[] tmp=new char[len];
        for(int i=0;i<len;i++) tmp[i]=st.pop();
        StringBuilder ans=new StringBuilder();
        for(int i=len-1;i>=0;i--) ans.append(tmp[i]);
        return ans.toString();
    }
}
