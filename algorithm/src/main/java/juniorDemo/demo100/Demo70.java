package juniorDemo.demo100;

import org.junit.Test;

//爬楼梯
public class Demo70 {
    @Test
    public void test01(){
        System.out.println(climbStairs(1));
    }
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        if ( n <= 1) return n;
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }
}
