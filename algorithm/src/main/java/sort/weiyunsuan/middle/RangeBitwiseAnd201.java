package sort.weiyunsuan.middle;

import org.junit.Test;

/**
 * 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 */
public class RangeBitwiseAnd201 {

    @Test
    public void test01(){
        int left = 100;
        int right = 101;
        rangeBitwiseAnd(left, right);
    }

    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        // 找到公共前缀
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }
}
