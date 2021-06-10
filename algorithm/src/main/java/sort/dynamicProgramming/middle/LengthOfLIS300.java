package sort.dynamicProgramming.middle;

import org.junit.Test;

import java.util.Arrays;

public class LengthOfLIS300 {

    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];

        Arrays.fill(dp,1);
        int max=1;

        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }

    @Test
    public void test01(){
        String s = "TIME DATE,ID STRING,SCOPR_ID ARRAY<STRING>,TG_NO STRING,TRANS_CAP FLOAT,O_N_5 STRING,O_N_7 STRING,ORG_NO STRING,N_DAYS INT,DAY_IDX STRING,N_METERS INT,N_EMETERS INT,CMIDS STRING,Y_MULT FLOAT,SUM_PHI STRING,LOSS_AVG FLOAT,STATUS INT,STATUS_TYPE STRING,TG_ERR STRING,BAD_PCT FLOAT,COMP_POINT INT,QUALITY_PCT STRING," +
                "DATA_QUALITY STRING";
        String ans = "";
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ',') {
                a++;
            }
        }
        System.out.println(a);
        System.out.println(ans);
    }
}
