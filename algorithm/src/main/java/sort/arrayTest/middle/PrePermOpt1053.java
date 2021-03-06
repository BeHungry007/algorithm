package sort.arrayTest.middle;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个正整数的数组 A（其中的元素不一定完全不同），
 * 请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、按字典序排列小于 A 的最大可能排列。
 *
 * 如果无法这么操作，就请返回原数组。
 *
 */
public class PrePermOpt1053 {

    @Test
    public void test0(){
        int[] arr = {3,1,1,3};
        prevPermOpt(arr);
    }

    public int[] prevPermOpt(int[] arr) {

        if (arr == null || arr.length == 0) return arr;
        int len = arr.length;
        int curMax = -1;
        int index = -1;
        boolean hasResult = false;
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i + 1] < arr[i]) {
                for (int j = i + 1; j < len; j++) {
                    if (arr[i] > arr[j]) {
                        hasResult = true;
                        if (arr[j] > curMax) {
                            curMax = arr[j];
                            index = j;
                        }
                    }
                }
                if (hasResult) {
                    int tmp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = tmp;
                    return arr;
                }
            }
        }
        return arr;
    }


    public int[] prevPermOpt1(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        boolean bo = false;
        int curMax = -1;
        int index = -1;
        for (int i = arr.length - 2; i < arr.length; i--) {
            if (arr[i + 1] < arr[i]) {
                for (int j = i + 1; j < arr.length; j++) {
                    bo = true;
                    if (arr[j] > curMax) {
                        curMax = arr[j];
                        index = j;
                    }
                }
                if (bo) {
                    int tmp = arr[index];
                    arr[index] = arr[i];
                    arr[i] = tmp;
                    return arr;
                }

            }
        }
        return arr;


    }
}
