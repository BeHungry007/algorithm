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
public class Search33 {

    @Test
    public void test01(){
        int[] nums = {4,5,6,7,0,1,2};
        search1(nums, 0);
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;

    }

    public int search1(int[] nums, int target) {
        int idx = -1;
        int left = 0;
        int right = nums.length - 1;
        int tmp = 0;
        while (left < right) {
            tmp = (left + right) / 2;
            if(nums[tmp] == target) return tmp;

            if (nums[0] < nums[tmp]) {
                if (nums[0] <= target && target < nums[tmp]) {
                    right = tmp - 1;
                } else {
                    left = tmp + 1;
                }
            } else {
                if (nums[tmp] < target && target <= nums[nums.length - 1]) {
                    left = tmp + 1;
                } else {
                    right = tmp - 1;
                }
            }
        }


        return idx;
    }
}
