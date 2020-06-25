package sort.arrayTest.middle;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - tmp) < Math.abs(target - ans)) {
                    ans = tmp;
                }
                if (tmp == target) {
                    return target;
                } else if(tmp > target){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }
}
