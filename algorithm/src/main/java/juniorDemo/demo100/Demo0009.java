package juniorDemo.demo100;

/**
 * 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Demo0009 {

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        Integer b = 0;
        while (x > b) {
            b = b * 10 + x % 10;
            x = x / 10;
        }
        if (x == b) {
            return true;
        }
        if (x == b / 10) {
            return true;
        }
        return false;
    }
}
