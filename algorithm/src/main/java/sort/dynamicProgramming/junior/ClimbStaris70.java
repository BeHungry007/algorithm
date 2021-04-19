package sort.dynamicProgramming.junior;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStaris70 {

    public int climbStairs(int n) {
        int[] arr1 = new int[n + 1];
        if ( n <= 1) return n;
        arr1[1] = 1;
        arr1[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            arr1[i] = arr1[i - 1] + arr1[i - 2];
        }
        return arr1[n];
    }
}
