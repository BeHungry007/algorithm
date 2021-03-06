package sort.arrayTest.middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 *
 */
public class FourSum18 {

    @Test
    public void test01(){
        int[] nums = {-4, -1, -1, 0, 1, 2};
        fourSum(nums, -1);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;

//        List<List<Integer>> ans = new ArrayList<>();
//        Arrays.sort(nums);
//        int len = nums.length;
//        if (nums.length < 4) return ans;
//        if (target < nums[0] + nums[1] + nums[2] + nums[3]
//                || target > nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4]) {
//            return ans;
//        }
//        int tmp;
//        for (int i = 0; i < nums.length - 3; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
//            if (target < nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3]) {
//                break;
//            }
//            if (target > nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3]) {
//                continue;
//            }
//            for (int j = i + 1; j < nums.length - 2; j++) {
//
//                if (j > i + 1 && nums[j] == nums[j - 1]) {
//                    continue;
//                }
//                // 如果 target 小于当前循环能得到的最小四数和，则跳出循环。
//                if (target < nums[i] + nums[j] + nums[j + 1] + nums[j + 2]) {
//                    break;
//                }
//                // 如果 target 大于此轮循环的最大和，则继续循环下一个比较大的第二位数。
//                if (target > nums[i] + nums[j] + nums[len - 1] + nums[len - 2]) {
//                    continue;
//                }
//
//                int left = j + 1;
//                int right = nums.length - 1;
//
//                while (left < right) {
//                    tmp = nums[i] + nums[j] + nums[left] + nums[right];
//                    if (tmp == target) {
//                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                        while (left < right && nums[left] == nums[left + 1]) left++;
//                        left++;
//                        while (left < right && nums[right] == nums[right - 1]) right--;
//                        right--;
//                    } else if (tmp > target) {
//                        right--;
//                        while (left < right && nums[right] == nums[right - 1]) right--;
//                    } else {
//                        while (left < right && nums[left] == nums[left + 1]) left++;
//                        left++;
//                    }
//                }
//            }
//
//        }
//        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
        int tar = -9;
        FourSum18.fourSum1(nums, tar);
    }
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3 ; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (target < nums[i] + nums[i+ 1] + nums[i + 2] + nums[i + 3]) {
                break;
            }
            if (target > nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3]) {
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (target < nums[i] + nums[j] + nums[j + 1] + nums[j + 2]) {
                    break;
                }
                if (target > nums[i] + nums[j] + nums[len - 1] + nums[len - 2]) {
                    continue;
                }

                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int tmp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (tmp == target) {
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        right--;
                    }else if (tmp > target) {
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        right--;
                    } else {
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        left++;
                    }
                }
            }

        }
        return ans;
    }
}
