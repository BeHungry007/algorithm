package sort.dynamicProgramming.middle;

/**
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 *
 */
public class IsInterleave97 {

    public static void main(String[] args) {
        IsInterleave97.isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }

    public static boolean isInterleave1(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[] f = new boolean[m + 1];

        f[0] = true;
//        f[0][1] = s2.charAt(0) == s3.charAt(0);
//        f[1][0] = s1.charAt(0) == s3.charAt(0);
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[j] = f[j] && s1.charAt(i - 1) == s3.charAt(p);
                }
                if (j > 0) {
                    f[j] = f[j] || f[j - 1] && s2.charAt(j - 1) == s3.charAt(p);
                }
            }
        }

        return f[m];
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
//        f[0][1] = s2.charAt(0) == s3.charAt(0);
//        f[1][0] = s1.charAt(0) == s3.charAt(0);
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
//                f[i][j] = (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p)) || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));

                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }
}
