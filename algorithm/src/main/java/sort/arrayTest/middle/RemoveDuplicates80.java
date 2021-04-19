package sort.arrayTest.middle;

/**
 * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *  
 *
 * 说明：
 *
 * 为什么返回数值是整数，但输出的答案是数组呢？
 *
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 */
public class RemoveDuplicates80 {

    public int removeDeplicates(int[] nums) {
        if (nums == null | nums.length == 0) {
            return 0;
        }
        int numsLen = nums.length;
        int count = 1;
        int len = 0;
        for (int i = 1; i <numsLen; i++) {
            if (nums[i] == nums[len] && count == 2) {
                continue;
            }
            if (nums[i] == nums[len]) {
                count = 2;
            }
            if (nums[i] != nums[len]) {
                count = 1;
            }
            len = len + 1;
            nums[len] = nums[i];

        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        if (nums == null | nums.length == 0) {
            System.out.println(0);
        }
        int numsLen = nums.length;
        int count = 1;
        int len = 0;
        for (int i = 1; i <numsLen; i++) {
            if (nums[i] == nums[len] && count == 2) {
                continue;
            }
            if (nums[i] == nums[len]) {
                count = 2;
            }
            if (nums[i] != nums[len]) {
                count = 1;
            }
            len = len + 1;
            nums[len] = nums[i];

        }
        System.out.println(len + 1);
    }

}
