package sort.arrayTest.junior;

import org.junit.Test;

/**
 *
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray53 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int ans = nums[0];
        int pre = 0;
        for (int i = 0; i < len; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(ans, pre);
        }
        return ans;
    }

    @Test
    public void test01(){
        int[] nums = {-2, 1};
        maxSubArray1(nums);
    }

    public int maxSubArray1(int[] nums) {
        if ( nums == null || nums.length == 0) return 0;
        int ans = nums[0];
        int pre = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(ans, pre);
        }
        return ans;
    }


}
