package ImportantDemo;

import java.util.HashMap;
import java.util.Map;

public class ZipStringJunior {
    public static void main(String[] args) {
        compressString("aabcccccaa");
    }

    public static String compressString(String S) {
        if (S == null || S.length() <= 2) {
            return S;
        }
        StringBuilder s = new StringBuilder().append(S.charAt(0));
        int cn = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i-1)) {
                cn += 1;
            } else {
                s.append(cn).append(S.charAt(i));
                cn = 1;
            }
        }
        return s.append(cn).length() > S.length() ? S:s.toString();
    }

    public static String com(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        String s = S.charAt(0) + "";
        int cn = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i-1)) {
                cn += 1;
            } else {
                s = s + cn + S.charAt(i);
                //s.append(cn).append(S.charAt(i));
                cn = 1;
            }
        }
        return (s + cn).length() > S.length() ? S:s.toString();
    }
}
