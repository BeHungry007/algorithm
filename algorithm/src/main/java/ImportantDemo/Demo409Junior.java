package ImportantDemo;

import org.junit.Test;

public class Demo409Junior {

    @Test
    public void test1() {
        System.out.println(longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
    }

    public int longestPalindrome(String s) {
        int[] arr = new int[58];
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'A';
            arr[a]++;
        }
        int result = 0;
        boolean isF = true;
        for (int i = 0; i < 58; i++) {
            if(isF && arr[i]%2 == 1) {
                result += 1;
                isF = false;
            }
            result += arr[i]/2 * 2;
        }
        return result;
    }
}
