package juniorDemo.demo100;

import org.junit.Test;

//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//你可以假设除了整数 0 之外，这个整数不会以零开头。
public class Demo66 {

    @Test
    public void test01(){

    }
    public int[] plusOne(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            nums[i]++;
            int j = nums[i] % 10;
            if (j != 0) return nums;
        }
        nums = new int[nums.length + 1];
        nums[0] = 1;
        return nums;
    }
}
