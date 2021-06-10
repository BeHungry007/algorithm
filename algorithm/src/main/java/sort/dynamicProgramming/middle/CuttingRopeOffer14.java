package sort.dynamicProgramming.middle;

/**
 * 剪绳子
 */
public class CuttingRopeOffer14 {

    public int cuttingRope(int n) {
        //dp[n]为在长度为n时，将其剪成整数长度的m段时的最大乘积
        //dp[n] = max(dp[n-i]*i); 0<i<n;

        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;
        for(int i = 4; i <= n; i++) {
            max = 0;
            for(int j = 1; j < i;j++){
                if(dp[i-j] * dp[j] > max){
                    max = dp[i-j] * dp[j];
                }
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
