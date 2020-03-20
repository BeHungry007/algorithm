package ImportantDemo;

import org.junit.Test;

import java.util.Arrays;

//获取最小的k个数
public class Interview40Junior {
    @Test
    public void test01(){
        int[] arr = {5,14,6,23,6,4,1,7,5,3};
        getLeastNumbers(arr, 4);
    }

    public int[] getLeastNumbers1(int[] arr, int k) {

        return null;
    }
    public int[] getLeastNumbers(int[] nums, int k) {
        if (nums.length == 0 || k == 0 || nums.length < k) {
            return nums;
        }
        return quickSearch(nums, 0, nums.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int i, int j, int k) {
        int a = partition(nums, i, j);
        if (a == k) {
            return Arrays.copyOf(nums, k + 1);
        }
        return a > k ? quickSearch(nums, i, a - 1, k) : quickSearch(nums, a + 1, j, k);
    }

    private int partition(int[] nums, int i, int j) {
        int first = nums[i];
        int a = i;
        int b = j + 1;
        while(true) {
            while(++a <= j && nums[a] < first);
            while (--b >= a && nums[b] > first);
            if (i >= j) {
                break;
            }
            int c = nums[a];
            nums[a] = nums[b];
            nums[b] = c;
        }
        nums[i] = nums[b];
        nums[b] = first;
        return b;
    }


    @Test
    public void test02(){
        int[] arr = {0,1,2};
        tt(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        int a = 1;
        int[] ints = Arrays.copyOf(arr, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println("-----------");
        System.out.println(++a);
        System.out.println(a);
        int b = 0;
        System.out.println(b++);
        System.out.println(b);
    }
    public void tt(int[] arr) {
        for (int i : arr) {
            i = arr[0];
        }
    }
}
