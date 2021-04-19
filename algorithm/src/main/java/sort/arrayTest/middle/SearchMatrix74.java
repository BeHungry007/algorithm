package sort.arrayTest.middle;

public class SearchMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l < r) {
            int tmp = (l + r) / 2;
            int ans = matrix[tmp / n][tmp % n];
            if (ans == target) {
                return true;
            } else if (ans > target) {
                r = tmp;
            } else {
                l = tmp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int target = 3;
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
