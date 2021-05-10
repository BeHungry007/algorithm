package sort.arrayTest.middle;

import org.elasticsearch.search.collapse.CollapseBuilder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），
 * 请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 */
public class FindDiagonalOrder498 {

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[m * n];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<>();

        for (int i = 0; i < m + n - 1; i++) {
            intermediate.clear();
            int r = i < m ? 0 : i - m + 1;
            int c = i < m ? i : m - 1;

            while (r < n && c > -1) {
                intermediate.add(mat[r][c]);
                ++r;
                --c;
            }

            if (i % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int j = 0; j < intermediate.size(); j++) {
                result[k++] = intermediate.get(i);
            }
        }
        return result;
    }

    public int[] findDiagonalOrder1(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        int n = mat.length;
        int m = mat[0].length;
        int row = 0, column = 0, direction = 1;
        int[] result = new int[m * n];
        int r = 0;
        while (row < n && column < m) {

            result[r++] = mat[row][column];
            int newRow = row + (direction == 1 ? -1 : 1);
            int newColumn = column + (direction == 1? 1 : -1);

            if (newRow < 0 || newRow == n || newColumn < 0 || newColumn == m) {
                if (direction == 1) {
                    row += (column == m - 1 ? 1 : 0);
                    column += (column < m - 1 ? 1 : 0);

                } else {
                    column += (row == n - 1 ? 1 : 0);
                    row += (row < n - 1 ? 1 : 0);
                }

                direction = 1 - direction;
            } else {
                row = newRow;
                column = newColumn;
            }
        }
        return result;
    }
}
