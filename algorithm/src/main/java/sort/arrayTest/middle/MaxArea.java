package sort.arrayTest.middle;

/**
 * 盛最多水的容器
 */
public class MaxArea {

    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        int tmp = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                tmp = height[left] * (right - left);
                left++;
            } else {
                tmp = height[right] * (right - left);
                right--;
            }
            area = Math.max(tmp, area);
        }
        return area;
    }
}
