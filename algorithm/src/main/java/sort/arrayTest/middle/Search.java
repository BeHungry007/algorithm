package sort.arrayTest.middle;

import org.junit.Test;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 */
public class Search {

    @Test
    public void test01(){
        int[] nums = {4,5,6,7,0,1,2};
        search(nums, 0);
    }
    public int search(int[] nums, int target) {
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;
        int tmp;
        while (left < right) {
            tmp = left + (right - left) / 2;
            if(nums[tmp] == target) return tmp;
            if (nums[0] > nums[tmp]) {
                if (nums[tmp] < target && target <= nums[nums.length - 1]) {
                    left = tmp;
                } else {
                    right = tmp - 1;
                }

            } else {
                if(nums[0] <= target && target < nums[tmp]) {
                    right = tmp - 1;
                } else {
                    left = tmp;
                }
            }
        }
        return idx;
    }
}
