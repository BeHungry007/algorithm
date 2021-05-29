package sort.weiyunsuan.middle;

import org.junit.Test;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 *
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 */
public class SingleNumber260 {

    @Test
    public void test01(){
        int a = 4;
        System.out.println(a ^= 2);
    }

    public int[] singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums) {
            if ((div & num) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
