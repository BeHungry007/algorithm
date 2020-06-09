package sort.ArrayTest.middle;


import org.junit.Test;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 */
public class NextPermutation {

    @Test
    public void test0(){
        int[] nums = {1,3,2};
        nextPermutation(nums);
    }

    /**
     * this is right!!!!!!!!!
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int i;
        boolean isTrue = true;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                isTrue = false;
                break;
            }
        }
        if (isTrue) {
            Arrays.sort(nums);
        } else {
            int tmp = nums[i];
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > tmp) {
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
            int right = nums.length - 1;
            for (int left = i + 1; left < right; i++) {
                tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

    }

    public void nextPermutation1(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
