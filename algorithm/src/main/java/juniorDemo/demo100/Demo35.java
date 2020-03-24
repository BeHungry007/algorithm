package juniorDemo.demo100;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
// 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

import org.junit.Test;

//假设没有重复的数值。
public class Demo35 {

    @Test
    public void test01(){

    }
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int a = (left + right) / 2;
            if (nums[a] == target) {
                return a;
            } else if (nums[a] < target) {
                left = a + 1;
            } else {
                right = a;
            }
        }
        return right;
    }
}
