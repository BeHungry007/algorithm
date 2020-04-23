package middleDemo.Demo100;

import org.junit.Test;

import java.util.HashMap;

public class Demo670 {
    @Test
    public void test01(){
        maximumSwap(9973);
    }
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

    @Test
    public void test02(){
        String s = "12345678";
        String substring = s.substring(1, 2);
        System.out.println(substring);
    }

}
