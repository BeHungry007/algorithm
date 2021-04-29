package sort.fenzhi.middle;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class FindKthLargest215 {

    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int l, int r, int target) {
        int i = randomPartition(nums, l, r);
        if (i == target) {
            return i;
        } else {
            return i < target ? randomPartition(nums, i + 1, r) : randomPartition(nums, l, i - 1);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i , r);
        return partition(nums, i, r);

    }

    private int partition(int[] nums, int l, int r) {
        int m = nums[r], n = l - 1;
        for (int i = l; i < r; i++) {
            if (nums[i] <= m) {
                n++;
                swap(nums, n, i);
            }
        }
        swap(nums, n + 1, r);
        return n + 1;
    }


    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
