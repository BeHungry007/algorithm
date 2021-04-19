package sort.arrayTest.middle;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class SpiralOrder54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }

        return order;

    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int l = 0, r = columns - 1, t = 0, b = rows - 1;
        int num = 1, tar = rows * columns;
        while(num <= tar){
            if (num == tar - 2) {
                System.out.println(1);
            }
            for(int i = l; i <= r; i++) {
                order.add(matrix[t][i]); // left to right.
                num++;
            }
            t++;
            for(int i = t; i <= b; i++) {
                num++;
                order.add(matrix[i][r]); // top to bottom.
            }
            r--;
            for(int i = r; i >= l; i--) {
                num++;
                order.add(matrix[b][i]); // right to left.
            }
            b--;
            for(int i = b; i >= t; i--) {
                num++;
                order.add(matrix[i][l]); // bottom to top.
            }
            l++;
        }
        return order;
    }

    @Test
    public void test0(){
        int[][] ans = {{1,2,3,4},
                       {5,6,7,8},
                       {9,10,11,12},
                       {13,14,15,16}};
        List<Integer> integers = spiralOrder(ans);
        System.out.println(integers);
    }
}
