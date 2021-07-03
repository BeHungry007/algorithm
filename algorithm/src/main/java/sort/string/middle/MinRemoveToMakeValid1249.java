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

    /**
     * 题解：  需要将全部的'('位置存储下来，而每次遇到')'的时候，都要获取到最新位置的'(',并将两者配对。
     *      1. 先构建一个len=s.length()长度的布尔数组invalidIndex，默认值为false。invalidIndex[i]为true，表示该位置需要删除。
     *      2. 使用先进后出的栈stack来存储'('的位置，每次poll出最新的位置；
     *      3. 遍历字符串，此时位置为i,
     *          当遍历到'('的时候，需要stack.push(i)，并且invalidIndex[i]=true;
     *          当遍历到')'的时候，
     *              需要弹出'('最新的位置：index = stack.poll()，并且将invalidIndex[i]和并invalidIndex[index]置为false
     *              如果stack为空，则该位置不能配对，需要invalidIndex[i]=true;
     *      4. 遍历invalidIndex，将invalidIndex[i]为true的s相同位置的字符删除。
     * @param s
     * @return
     */
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
