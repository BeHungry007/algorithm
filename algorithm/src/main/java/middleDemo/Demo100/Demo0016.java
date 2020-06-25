package middleDemo.Demo100;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 *
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 *
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 */
public class Demo0016 {
    @Test
    public void test01(){

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - ans) > Math.abs(target - sum)){
                    ans = sum;
                }
                if (sum > target) {
                    right--;
                } else if(sum < target) {
                    left++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }

    public int threeSumClosest1(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length -1 ;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - ans) > Math.abs(target - tmp)) {
                    ans = tmp;
                }
                if (tmp > target) {
                    right--;
                } else if (tmp < target) {
                    left++;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }
}
