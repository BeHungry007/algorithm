package sort.arrayTest.middle;

/**
 * 获得礼物的最大价值
 */
public class GetMaxValueOffer47 {

    //正确！
    public int getMaxValue(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int[] tmps = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    tmps[j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    tmps[j] = tmps[j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    tmps[j] = tmps[j] + grid[i][j];
                    continue;
                }
                tmps[j] = Math.max(tmps[j - 1], tmps[j]) + grid[i][j];
            }
        }
        return tmps[n - 1];
    }
}
