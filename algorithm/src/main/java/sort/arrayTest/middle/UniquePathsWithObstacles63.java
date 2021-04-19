package sort.arrayTest.middle;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 */
public class UniquePathsWithObstacles63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int ans = 0;
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        int[] col = new int[n];
        if (obstacleGrid[0][0] == 0) {
            col[0] = 1;
        } else {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        col[j] = 0;
                    } else {
                        col[j] = col[j];
                    }
                }
                if (obstacleGrid[i][j] == 1) {
                    col[j] = 0;
                } else {
                    col[j] = col[j - 1] + col[j];
                }
            }
        }
        return col[n - 1];
    }

}
