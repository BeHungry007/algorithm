package sort.ArrayTest.hard;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 */
public class FirstMissingPositive {

    @Test
    public void test01(){
        int[] nums = {1,2,0};
        firstMissingPositive(nums);
    }
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int idx = 0;
        for (idx = 0; idx < nums.length; idx++) {
            if (nums[idx] > 0) {
                break;
            }
        }
        int ans = 0;
        while (ans + idx < nums.length) {
            if (nums[ans++ + idx] != ans) {
                return ans;
            }
        }
        return ans++;

    }
}
