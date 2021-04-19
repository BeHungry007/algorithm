package sort.dynamicProgramming.middle;

import java.util.Arrays;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 */
public class UniquePaths62 {

    public int uniquePaths1(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] = cur[j-1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n-1];

    }

    public int uniquePaths4(int m, int n) {
        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                pre[j] = pre[j] + pre[j - 1];
            }
        }

        return pre[n-1];

    }

    public int uniquePaths2(int m, int n) {
        int[] pre = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    pre[j] = 1;
                    continue;
                }
                if (i == 0) {
                    pre[j] = 1;
                    continue;
                }
                pre[j] = pre[j] + pre[j - 1];
            }
        }

        return pre[n-1];

    }

    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }





}

