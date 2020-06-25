package highDemo.demo100;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.jdi.Type;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * 寻找两个有序数组的中位数
 */
public class Demo04 {

    @Test
    public void test1() {
        int a = 2;
        int b = 3;
        double v = (a + b) / 2.0;
        System.out.println(v);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return form(nums2);
        }
        if (nums2 == null) {
            return form(nums1);
        }
        int len = nums1.length + nums2.length;
        int a = 0, b = 0;
        while (a < nums1.length && b < nums2.length) {
            if (a + b < len) {
                if (nums1[a] < nums2[b]) {
                    a++;
                } else {
                    b++;
                }
            }
        }
        return 0.0;
    }

    public double form(int[] nums) {
        int length = nums.length;
        if (length % 2 == 0) {
            return (nums[length / 2] + nums[length / 2 - 1]) / 2.0;
        } else {
            return nums[length / 2];
        }
    }

}
