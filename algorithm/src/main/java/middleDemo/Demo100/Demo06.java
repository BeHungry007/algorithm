package middleDemo.Demo100;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Z字形变换
 */
public class Demo06 {

    @Test
    public void test01(){
        String s = "LEETCODEISHIRING";
        String convert = convert(s, 4);
        System.out.println(convert);
    }

    public String convert2(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    public String convert(String s, int numRows) {
        ArrayList<StringBuilder> arrList = new ArrayList<>();
        if (numRows == 1) return s;
        for (int i = 0; i < s.length() && i < numRows; i++) {
            arrList.add(new StringBuilder());
        }
        int rows = 0;
        boolean goToDown = false;
        for (int i = 0; i < s.length(); i++) {
            arrList.get(rows).append(s.charAt(i));
            if (rows == 0 || rows == numRows - 1) goToDown = !goToDown;
            rows += goToDown ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : arrList) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }
    /**
     * 大错特错！！！！！！！！！！！！！！！！
     * @param s
     * @param numRows
     * @return
     */
    public String convert1(String s, int numRows) {
        String[] arr = new String[numRows];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "";
        }
        if (numRows == 2) {
            String str = "";
            for (int i = 0; i < s.length(); i++) {
                str = str + s.charAt(i);
                i++;
            }
            for (int i = 1; i < s.length(); i++) {
                str = str + s.charAt(i);
                i++;
            }
            return str;
        }
        int temp = numRows + numRows / 2;
        for (int i = 0; i < s.length(); i++) {
            if (i % temp < numRows) {
                arr[i % temp] = arr[i % temp] + s.charAt(i);
            } else {
                arr[numRows - 2 - (i+ numRows / 2)%temp] = arr[numRows - 2 - (i+ numRows / 2)%temp] + (s.charAt(i));
            }
        }
        String str = "";
        for (int i = 0; i < numRows; i++) {
            str = str + arr[i];
        }
        return str;
    }
}
