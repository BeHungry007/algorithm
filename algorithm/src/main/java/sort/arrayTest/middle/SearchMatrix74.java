package sort.arrayTest.middle;

import org.junit.Test;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 */
public class SearchMatrix74 {

    //正确答案！
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while ( left <= right) {
            int tmp = (left + right) / 2;
            int ans = matrix[tmp / n][tmp % n];
            if (ans == target) {
                return true;
            } else if (ans < target) {
                left = tmp + 1;
            } else {
                right = tmp - 1;
            }
        }
        return false;
    }

    @Test
    public void test0(){
        int[][] matrix = new int[][]{
                {1,  3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        searchMatrix1(matrix, 13);

    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while ( left <= right) {
            int tmp = (left + right) / 2;
            int ans = matrix[tmp / n][tmp % n];
            if (ans == target) {
                return true;
            } else if (ans < target) {
                left = tmp + 1;
            } else {
                right = tmp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 13;
        int[][] matrix = new int[][]{
                {1,  3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        if (matrix.length == 0) System.out.println("true");;

        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int tmp = (l + r) / 2;
            int ans = matrix[tmp / n][tmp % n];
            if (ans == target) {
                System.out.println("true");
            } else if (ans > target) {
                r = tmp - 1;
            } else {
                l = tmp + 1;
            }
        }
    }
}
