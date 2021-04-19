package sort.arrayTest.middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 */
public class ThreeSum15 {

    @Test
    public void test0(){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum(nums);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[left] + nums[left + 1] > 0) return ans;
            while (left < right) {
                int a = nums[i] + nums[left] + nums[right];
                if (a == 0) {
                    ans.add(Arrays.asList(nums[i] , nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (a > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> ans(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[left] + nums[left + 1] > 0) return ans;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (tmp == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                    right--;
                } else if (tmp < 0) {
                    left++;
                } else if (tmp > 0) {
                    right--;
                }
            }
        }
        return ans;

    }
}
