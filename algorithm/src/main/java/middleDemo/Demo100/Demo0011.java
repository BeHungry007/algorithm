package middleDemo.Demo100;

import org.junit.Test;

/**
 * 盛最多水的容器
 *
 *
 */
public class Demo0011 {
    @Test
    public void test01(){
        int[] arr = {1,8,6,2,5,4,8,3,7};
        maxArea(arr);
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        int tmp = 0;
        while (left <= right) {
            if (height[left] < height[right]) {
                tmp = height[left] * (right - left);
                left++;
            } else {
                tmp = height[right] * (right - left);
                right--;
            }
            area = Math.max(area, tmp);
        }
        return area;
    }
}
