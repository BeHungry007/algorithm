package sort.string.middle;

import org.junit.Test;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Multiply43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    @Test
    public void test01(){
        multiply1("2", "3");
    }
    public String multiply1(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length() - 1, n = num2.length() - 1;

        String ans = "0";
        for (int i = n; i >= 0 ; i--) {
            StringBuffer sb = new StringBuffer();
            for (int j = n; j > i ; j--) {
                sb.append("0");
            }
            int y = num2.charAt(i) - '0';
            int curr = 0;
            for (int j = m; j >= 0 ; j--) {
                curr = curr + (num1.charAt(j) - '0') * y;
                sb.append(curr % 10);
                curr = curr / 10;
            }
            if (curr != 0) {
                sb.append(curr % 10);
            }
            ans = addStr(ans, sb.reverse().toString());
        }
        return ans;
    }

    private String addStr(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1;
        StringBuffer ans = new StringBuffer();
        int curr = 0;
        while (m >= 0 || n >= 0) {
            int x = (m >= 0 ? num1.charAt(m) - '0' : 0);
            int y = (n >= 0 ? num2.charAt(n) - '0' : 0);
            curr = curr + x + y;
            ans.append(curr % 10);
            curr = curr / 10;
            m--;
            n--;
        }
        if (curr != 0) {
            ans.append(curr);
        }
        ans.reverse();
        return ans.toString();

    }
}
