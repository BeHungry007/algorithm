package sort.arrayTest.middle;

/**
 * 最短路径
 */
public class MinPathSum64 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][columns - 1];
    }

//    public int minPathSum2(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//        int rows = grid.length, columns = grid[0].length;
//        int[] dp = new int[columns];
//        dp[0] = grid[0][0];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < columns; j++) {
//                if (i == 0 && j != 0) {
//                   dp[j] = grid[i][j]  + dp[j - 1];
//                }
//                if (i != 0 && j == 0) {
//                    dp[j] = grid[i][j] + dp[j];
//                }
//                if (i > 0 && j > 0) {
//                    dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
//                }
//            }
//        }
//        return dp[columns - 1];
//    }

//    public static int minPathSum2(int[][] grid) {
//
//    }

}
