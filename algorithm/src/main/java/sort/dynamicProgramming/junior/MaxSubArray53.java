package sort.dynamicProgramming.junior;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray53 {

    /**
     * 1. 初始化：将数组中的第一个数值设定为最大值ans;
     * 2.
     * @param nums
     * @return  简单易懂！！！！
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int cur = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (cur < 0) {
                cur = 0;
            }
            cur += nums[i];
            res = Math.max(res, cur);
        }

        return res;
    }

    public int maxSubArray1(int[] nums) {

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
