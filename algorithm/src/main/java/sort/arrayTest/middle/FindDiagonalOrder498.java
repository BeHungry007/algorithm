package sort.arrayTest.middle;

import org.elasticsearch.search.collapse.CollapseBuilder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），
 * 请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 *
 */
public class FindDiagonalOrder498 {

    /**
     * 题解：
     *      1. 按照从右上到左下的方向取值，每个对角线上位置的行列之和是相同的，范围是0~m+n-1;
     *      2. 遍历这个和 sum，每次都从右上到左下；
     *          此处，可以将sum值的增加理解为：先遍历数组第一行，到最后一个数字之后，继续往下遍历。
     *      3. row + column = sum; 每次只需要判定row是不是超过数组的m：
     *          如果没有超过，则row都是从0开始增加1，此时column递减1；
     *          否则，row的值为 sum - m + 1;
     *
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[m * n];
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<>();

        for (int sum = 0; sum < m + n - 1; sum++) {
            intermediate.clear();
            int r = sum < m ? 0 : sum - m + 1;
            int c = sum < m ? sum : m - 1;

            while (r < n && c > -1) {
                intermediate.add(mat[r][c]);
                ++r;
                --c;
            }

            if (sum % 2 == 0) {
                Collections.reverse(intermediate);
            }

            for (int j = 0; j < intermediate.size(); j++) {
                result[k++] = intermediate.get(sum);
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
