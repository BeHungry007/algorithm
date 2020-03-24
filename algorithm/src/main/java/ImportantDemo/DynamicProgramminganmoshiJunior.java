package ImportantDemo;
//一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
// 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
// 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数

import org.junit.Test;

public class DynamicProgramminganmoshiJunior {
    @Test
    public void test01(){

    }
    public int message(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int a = 0;
        int b = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int d1 = Math.max(a, b);
            int d2 = a + nums[i];
            a = d1;
            b = d2;
        }
        return Math.max(a, b);
    }
}
