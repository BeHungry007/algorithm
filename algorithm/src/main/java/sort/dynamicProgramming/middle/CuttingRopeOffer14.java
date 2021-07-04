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
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int len = 4;len <= n; len++){
            //到len位置，遍历(len - k) * k所有可能，然后获取到最大值
            for(int k = 2; k < len-1; k++){
                dp[len] = Math.max(dp[len], dp[k] * dp[len-k]);
            }
        }
        return dp[n];
    }
}
