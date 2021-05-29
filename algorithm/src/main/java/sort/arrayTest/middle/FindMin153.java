package sort.arrayTest.middle;

/**
 * 寻找旋转排序数组中的最小值
 */
public class FindMin153 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        int ans = nums[0];
        if (nums[right] > nums[left]) return nums[left]; // 数组没有旋转，直接返回最小值nums[left]
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];

            if (nums[mid - 1] > nums[mid]) return nums[mid];

            if (nums[left]<nums[mid]) left = mid + 1;     // 这里也可以写成nums[left]<=nums[mid]
            else if(nums[mid] < nums[right]) right = mid-1; // 但由于数组中没有重复元素,所以不可能等于，写<就行
        }
        return -1;
    }
}
