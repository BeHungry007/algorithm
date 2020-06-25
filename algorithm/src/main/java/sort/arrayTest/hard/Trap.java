package sort.arrayTest.hard;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap {

    public int trap1(int[] height) {
        int sum = 0;
        int len = height.length;
        for (int i = 1; i < len - 1; i++) {
            int max_left = 0;
            for (int j = 0; j < i; j++) {
                if(height[j] > max_left) {
                    max_left = height[j];
                }
            }

            int max_right = 0;
            for (int j = i + 1; j < len; j++) {
                if (height[j] >max_right) {
                    max_right = height[j];
                }
            }
            int min = Math.min(max_left, max_right);
            if (min > height[i]) {
                sum += (min - height[i]);
            }

        }
        return sum;
    }


    //动态规划
    public int trap2(int[] height) {
        int sum = 0;
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];

        for (int i = 1; i <len; i++) {
            max_left[i] = Math.max(height[i - 1], max_left[i - 1]);
        }
        for (int i = len - 2; i > 0; i--) {
            max_right[i] = Math.max(height[i + 1], max_right[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    public int trap3(int[] height) {
        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2;
        //第一种：
//        while (left <= right) {
//            if (height[left - 1] < height[right + 1]) {
//                max_left = Math.max(max_left, height[left - 1]);
//                int min = max_left;
//                if (min > height[left]) {
//                    sum += (min - height[left]);
//                }
//                left++;
//            } else {
//                max_right = Math.max(max_right, height[right + 1]);
//                int min = max_right;
//                if (min > height[right]) {
//                    sum += (min - height[right]);
//                }
//                right--;
//            }
//        }
        //第二种：
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum += (min - height[left]);
                }
                left++;
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum += (min - height[right]);
                }
                right--;
            }
        }
        return sum;

    }
}





