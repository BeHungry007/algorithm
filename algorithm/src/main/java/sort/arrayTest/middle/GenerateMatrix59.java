package sort.arrayTest.middle;

/**
 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *  
 */

public class GenerateMatrix59 {


    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }


    public int[][] generateMatrix1(int n) {
        int[][] ans = new int[n][n];
        boolean[][] used = new boolean[n][n];
        int[][] dirs = {{0,1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, column = 0, indexDirs = 0;
        for (int i = 1; i <= n * n; i++) {
            ans[row][column] = i;
            used[row][column] = true;
            int nextRow = row + dirs[indexDirs][0], nextColumn = column + dirs[indexDirs][1];
            if (nextColumn >= n || nextColumn < 0 || nextRow >= n || nextRow < 0 || used[nextRow][nextColumn]) {
                indexDirs = (indexDirs + 1) % 4;
            }
            row += dirs[indexDirs][0];
            column += dirs[indexDirs][1];
        }
        return ans;
    }

}
