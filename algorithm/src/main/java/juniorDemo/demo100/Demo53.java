package juniorDemo.demo100;

import org.junit.Test;

import java.util.Map;

//最大子序和
public class Demo53 {
    @Test
    public void test01(){

    }

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right){
            return nums[left];
        }
        int p = (left + right) /2;
        int leftSum = helper(nums, left , p);
        int rightSum = helper(nums, p+1, right);
        int ccrossSum = ccrossSum(nums, left, right, p);
        return Math.max(Math.max(leftSum, rightSum), ccrossSum);
    }

    private int ccrossSum(int[] nums, int left, int right, int p) {
        int leftSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = p; i >left - 1 ; i--) {
            currSum += nums[i];
            leftSum = Math.max(leftSum, currSum);
        }
        int rightSum = Integer.MIN_VALUE;
        currSum = 0;
        for (int i = p+1; i < right + 1; i++) {
            currSum += nums[i];
            rightSum = Math.max(rightSum, currSum);
        }
        return leftSum + rightSum;

    }
}
