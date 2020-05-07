package middleDemo.Demo100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 */
public class Demo018 {
    @Test
    public void test01(){
        int[] nums = {-1,2,2,-5,0,-1,4};
        fourSum(nums, 3);
    }

    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        if (len < 4) return list;
        if (target < nums[0] + nums[1] + nums[2] + nums[3]
                || target > nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4]) {
            return list;
        }

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (target < nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) {
                break;
            }
            if (target > nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // 如果 target 小于当前循环能得到的最小四数和，则跳出循环。
                if (target < nums[i] + nums[j] + nums[j + 1] + nums[j + 2]) {
                    break;
                }
                // 如果 target 大于此轮循环的最大和，则继续循环下一个比较大的第二位数。
                if (target > nums[i] + nums[j] + nums[len - 1] + nums[len - 2]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        while (left <right && nums[left] == nums[left - 1]) left++;
                        right--;
                        while (left <right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target){
                        left++;
                        while (left <right && nums[left] == nums[left - 1]) left++;
                    } else {
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                }
            }
        }
        return list;
    }
}
