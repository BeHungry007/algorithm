package sort.arrayTest.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */

public class LetterCombinations {
    String[] test = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    List<String> ans = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits == "") {
            return ans;
        }
        dfs(digits, 0, "");
        return ans;


    }

    public void dfs(String digits, int index, String s) {
        if (index == digits.length()) {
            ans.add(s);
            return;
        }
        char c = digits.charAt(index);
        String an = test[c - '0'];
        for (int i = 0; i < an.length(); i++) {
            dfs(digits, index + 1, an.charAt(i) + s);
        }
        return;
    }

}
