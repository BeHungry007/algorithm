package sort.digui.middle;

/**
 * 把数字翻译成字符串
 */
public class GetTranslationCount46 {

    public int GetTranslationCount(int number) {
        return Solution1(number);
    }


    public int Solution1(int number) {
        if(number<0) {
            return 0;
        }
        String strNum = String.valueOf(number);
        int length = strNum.length();
        int[] count = new int[length];
        for(int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                count[i] = 1;
            } else {
                count[i] = count[i + 1];
                int a = strNum.charAt(i) - '0';
                int b = strNum.charAt(i + 1) - '0';
                int convertNum = a*10 + b;
                if (convertNum >= 10 && convertNum <= 25) {
                    if (i == length - 2) {
                        count[i] += 1;
                    }else {
                        count[i] += count[i + 2];
                    }
                }
            }
        }
        return count[0];
    }
}
