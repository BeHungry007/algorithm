package sort.arrayTest.middle;

import org.junit.Test;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 */
public class SortColors75 {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int len = nums.length;
        int p0 = 0, p2 = len - 1;
        for (int i = 0; i < p2; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0] = 0;
                p0++;

            }

            while (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }

        }
    }


    @Test
    public void test0(){
        int[] nums = {2,0,2,1,1,0};
        sortColors2(nums);
    }
    public void sortColors2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        int red = 0;
        int blue = len - 1;
        for (int i = 0; i < blue; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[red];
                nums[red] = 0;
                red++;
            }
            if (nums[i] == 2) {
                nums[i] = nums[blue];
                nums[blue] = 2;
                blue--;
                if (i > 0) {
                    i--;
                }
            }
        }
    }
}

