package sort.string.middle;

import org.junit.Test;

import java.util.Stack;

/**
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 *
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 *
 * 请返回任意一个合法字符串。
 *
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 *
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 *
 */
public class MinRemoveToMakeValid1249 {

    @Test
    public void test01(){
        String s = "lee(t(c)o)de)";
        minRemoveToMakeValid1(s);

    }

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> bracketIndex = new Stack<>();
        boolean[] invalidIndex = new boolean[s.length()];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracketIndex.push(i);
                invalidIndex[i] = true;
            }
            if (s.charAt(i) == ')') {
                if (bracketIndex.empty()) {
                    invalidIndex[i] = true;
                } else {
                    invalidIndex[bracketIndex.pop()] = false;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndex[i]) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();

    }

    public String minRemoveToMakeValid1(String s) {
        Stack<Integer> bracketIndex = new Stack<>();
        boolean[] inValid = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bracketIndex.push(i);
                inValid[i] = true;
            }

            if (s.charAt(i) == ')') {
                if (bracketIndex.isEmpty()) {
                    inValid[i] = true;
                } else {
                    inValid[bracketIndex.pop()] = false;

                }
            }
        }
        String ans = "";
        for(int i = 0; i < s.length(); i++) {
            if (!inValid[i]) {
                ans += s.charAt(i);
            }
        }
        return ans;
    }
}
