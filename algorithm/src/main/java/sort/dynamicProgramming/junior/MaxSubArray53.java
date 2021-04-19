package sort.dynamicProgramming.junior;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray53 {

    public int maxSubArray(int[] nums) {

        if (nums.length == 1) return nums[0];
        int ans = nums[0];
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp = Math.max(tmp, tmp + nums[i]);
            if (ans < tmp) {
                ans = tmp;
            }
        }
        return ans;

    }

}
