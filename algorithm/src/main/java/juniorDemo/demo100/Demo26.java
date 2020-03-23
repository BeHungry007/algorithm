package juniorDemo.demo100;

import org.junit.Test;

//删除排序数组中的重复项,f返回值为移除后的数组长度。
public class Demo26 {

    @Test
    public void test1() {

    }

    public int removeDuplicates(int[] nums) {
        if (nums ==  null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[count]) {
                nums[++count] = nums[i];
            }
        }
        return count + 1;
    }
}
