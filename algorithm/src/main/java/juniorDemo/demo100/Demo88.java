package juniorDemo.demo100;

import org.junit.Test;

//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
public class Demo88 {
    @Test
    public void test01(){

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m != 0 && n != 0) {
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m = m - 1;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n = n - 1;
            }
        }
        while (n != 0) {
            nums1[n - 1] = nums2[n - 1];
            n = n - 1;
        }
    }
}
