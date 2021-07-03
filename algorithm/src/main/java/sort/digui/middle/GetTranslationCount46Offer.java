package sort.digui.middle;

/**
 * 把数字翻译成字符串
 */
public class GetTranslationCount46Offer {

    public int GetTranslationCount(int number) {
        return Solution1(number);
    }

    /**
     * 题解：  从数字的个位数开始，一个一个的排查；
     *      1. 先获取到数字的长度len；
     *      2. 创建一个长度为len的数组；
     *          存放数据的含义：当前index在数字中所在位置往前所有数据所能组成的全部字符串数量之和(len-1时 为1)(包括当前位置)
     *      3. 遍历到index的时候，先将index+1的值复制给index,此时是把index所处位置看成一个字符：
     *          将index的数字和index+1的数字合成一个数字sum。
     *          sum > 26  无法组成一个字符，故需要过滤；
     *          sum < 10  组成的组成的字符和index + 1一致，已经添加过；
     *          10 <= sum <= 26 有了新的字符产生，需要加上index + 2的数值大小；
     *          ps：当index = len -2时，没有index + 2，只有index和index+1两个数字组成的字符，
     *              因为已经将index+1的值赋给了index，此时只需要将组合起来的字符添加到种类里面即可。
     * @param number
     * @return
     */
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
