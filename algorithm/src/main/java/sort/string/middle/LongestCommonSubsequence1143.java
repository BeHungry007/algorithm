package sort.string.middle;

import org.junit.Test;

/**
 * 最长公共子序列
 *
 */
public class LongestCommonSubsequence1143 {

    // 正确答案！

    /**
     * 1. 先获取两个字符串的长度m 和 n, 然后创建一个 (m + 1) * (n + 1)的二维数组；（默认每个位置的数据为0）
     * 2. 嵌套遍历两个字符串，遍历的时候起始位置都为1，而在判定是否相等的时候，都需要减1.
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null) return 0;
        int m = text1.length();
        int n = text2.length();
        //多申请一行一列，是因为dp[0][0]需要处理越界，所以改成dp[1][1]
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        if(text1 == null || text2 == null) return 0;
        int m = text1.length();
        int n = text2.length();
        //多申请一行一列，是因为dp[0][0]需要处理越界，所以改成dp[1][1]
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test01(){
        String s1 = "abd";
        String s2 = "cad";
        System.out.println(longestCommonSubsequence1(s1, s2));
    }
}
