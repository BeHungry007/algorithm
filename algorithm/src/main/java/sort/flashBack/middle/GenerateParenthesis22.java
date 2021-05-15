package sort.flashBack.middle;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 */

public class GenerateParenthesis22 {

    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void dfs(List<String> ans, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == max * 2) {
            ans.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append("(");
            dfs(ans, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            dfs(ans, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }



    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

