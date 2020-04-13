package middleDemo.Demo100;

import org.junit.Test;

public class Demo1049 {
    @Test
    public void test01(){
        int[] arr = {2, 7, 1, 4, 7, 2};
        lastStoneWeightII(arr);
    }
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        int length = stones.length;
        for(int i=0;i<length;i++){
            total+=stones[i];
        }
        //当有i块石头时，包里的最大重量为j
        int[][] dp = new int[length+1][total/2+1];
        for(int i = 1;i<length+1;i++){
            for(int j= 1;j<total/2+1;j++){
                if(stones[i-1]<=j){
                    int[] arr = {2, 7, 1, 4, 7, 2};
                    dp[i][j] = Math.max(dp[i-1][j-stones[i-1]]+stones[i-1],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
            for (int j = 0; j < total/2 ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(dp[i][total/2]);
        }
        return total - (2*dp[length][total/2]);
    }
}
