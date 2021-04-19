package sort.dynamicProgramming.middle;

/**
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
 *
 * 例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，
 * 从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。
 * 注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
 *
 * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 */
public class NumDecodings91 {

    public int numDecodings(String s) {
        if (s.charAt(0)=='0') return 0;
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=1;i<n;i++) {
            if (s.charAt(i)=='0') {
                if(s.charAt(i-1)=='1' || s.charAt(i-1)=='2'){
                    if (i==1) dp[i] = 1;
                    else dp[i] = dp[i-2];
                }
                else
                    return 0;
            }
            else {
                int value = 10*(s.charAt(i-1)-'0') + (s.charAt(i)-'0');
                if (value>=11 && value<=26) {
                    if (i==1) dp[i] = dp[0] + 1;
                    else dp[i] = dp[i-1] + dp[i-2];
                }
                else dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }
}
