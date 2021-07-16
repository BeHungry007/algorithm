package sort.string.middle;

import java.util.Stack;

/**
 * 给定一个只包含 ‘(’ 和 ‘)’ 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: “(()”
 * 输出: 2
 * 解释: 最长有效括号子串为 “()”
 * 示例 2:
 *
 * 输入: “)()())”
 * 输出: 4
 * 解释: 最长有效括号子串为 “()()”
 */
public class longestValidParentheses32 {

    /**
     * 1. 直接遍历整个字符串：
     *  如果为"(",则stack里面添加该字符所在的index；
     *  如果为")":
     *      首先判定stack是不是为空，如果为空，则将left = i,此为不可用的字符所在的index，其后面的再次判定括号是否合格的时候需要减去该值；
     *      stack不为空，则stack.pop();
     *          此时，再次判定stack为空？
     *              如果为空，则此时满足条件的长度为i - left，和count做比较取大者；
     *              如果不为空，则获取一下当前stack里面下一次弹出来的数值是多少，注意此时使用peek而不是push,长度为i - stack.peek()
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 1)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0, left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (!stack.isEmpty())
                        count = Math.max(count, i - stack.peek());
                    else
                        count = Math.max(count, i - left);
                } else
                    left = i;
            }
        }
        return count;
    }
}
