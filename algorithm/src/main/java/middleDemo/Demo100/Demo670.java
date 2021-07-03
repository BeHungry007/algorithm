package middleDemo.Demo100;

import org.junit.Test;

import java.util.HashMap;

/**
 * 最大交换
 */
public class Demo670 {

    @Test
    public void test01(){
        maximumSwap(9973);
    }

    /**
     * 题解：
     *      1. 将0 - 9每个数字出现的最大位数记录到arr数组中,arr数组的index为数字，value为所在最大位置；
     *      2.  遍历num的字符串，只需要满足i.index < index && i.value < value即为所求值
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        char[] A = Integer.toString(num).toCharArray();
        String s = "" + num;
        int[] arr = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            arr[a] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 9; j > s.charAt(i) - '0' ; j--) {
                if (arr[j] > i) {
                    char tmp = A[i];
                    A[i] = A[arr[j]];
                    A[arr[j]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }

}
