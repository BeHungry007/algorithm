package sort.string.junior;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        if ( num1 == null && num2 == null) {
            return null;
        } else if (num1 == null && num2 != null) {
            return num2;
        } else if ( num1 != null && num2 == null) {
            return num1;
        }
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        int adds = 0;
        for (int i = len1, j = len2 ; i >= 0 || j >= 0 ; i--,j--) {
            int m = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = m + n + adds;
            ans.append(tmp % 10);
            adds = tmp / 10;
        }
        if (adds != 0) {
            ans.append(adds);
        }
        return ans.reverse().toString();
    }
}
