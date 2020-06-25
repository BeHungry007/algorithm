package sort.binarySearch.junior;

import org.junit.Test;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 */
public class MySqrt {

    @Test
    public void test01(){
        System.out.println(mysqrt1(2147395599));
        System.out.println(mySqrt(2147395599));

    }

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (x == (long)mid * mid) {
                return mid;
            } else if ((long)mid * mid > x){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }

    public int mysqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
