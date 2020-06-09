package sort.ArrayTest.junior;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> arr = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (arr.containsKey(tmp)) {
                return new int[]{arr.get(tmp), i};
            } else {
                arr.put(nums[i], i);
            }
        }
        return null;
    }
}
