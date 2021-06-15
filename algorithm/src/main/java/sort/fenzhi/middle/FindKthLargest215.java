package sort.fenzhi.middle;

import org.junit.Test;

import java.util.*;

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

    public int findKthLargest1(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.offer(nums[i]);
            } else {
                queue.offer(Math.max(queue.poll(), nums[i]));
            }
        }
        return queue.poll();
    }

    @Test
    public void test01(){
        int k = 2;
        int[] nums = {5,4,6,3,7,2,8};
        Queue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.offer(nums[i]);
            } else {
                queue.offer(Math.max(queue.poll(), nums[i]));
            }
        }
        System.out.println(queue.peek()); //7
        System.out.println(queue);        //[7,8]
        System.out.println(queue.poll()); //7
        System.out.println(queue);        //[8]
    }
}
