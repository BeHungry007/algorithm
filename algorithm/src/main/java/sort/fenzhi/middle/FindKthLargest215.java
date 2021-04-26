package sort.fenzhi.middle;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest215 {

    Random random = new Random();

    public int findKthLargest1(int[] nums, int k) {
        return quickSelect1(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect1(int[] a, int l, int r, int index) {
        int q = randomPartition1(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect1(a, q + 1, r, index) : quickSelect1(a, l, q - 1, index);
        }
    }

    public int randomPartition1(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition1(a, l, r);
    }

    public int partition1(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }


    @Test
    public void test01(){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 2;
        findKthLargest(nums, 4);
    }

    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            count++;
            if (count == k) {
                return nums[i];
            }
        }
        return -1;

    }

    public int quickSelect(int[] nums, int l, int r, int index) {
        int i = randomPartition(nums, l, r);

        if (i == index) {
            return nums[i];
        } else {
            return i < index ? quickSelect(nums,i + 1, r, index) : quickSelect(nums, l, i - 1, index);
        }
    }

    public int randomPartition(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(nums, i, right);
        return partition(nums, left, right);


    }

    public int partition(int[] nums, int left, int right) {
        int m = nums[right], n = left - 1;
        for(int i = left; i < right; ++i) {
            if (nums[i] <= m) {
                swap(nums, ++n, i);
            }
        }
        swap(nums,n + 1, m);
        return n + 1;
    }


    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
