package middleDemo.Demo100;

import java.util.ArrayList;
import java.util.Random;

//打乱一个没有重复元素的数组
public class Demo384 {
    class Solution {
        public int[] arr;
        public int[] nums;
        Random rand = new Random();
        public Solution(int[] nums) {
            this.nums = nums;
            arr = nums.clone();
        }
        public int[] reset() {
            return nums;
        }
        public int randRange(int min, int max) {
            return rand.nextInt(max - min) + min;
        }
        public void swap(int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        public int[] shuffle() {
            for (int i = 0; i < nums.length; i++) {
                swap(i, randRange(i, nums.length));
            }
            return arr;
        }
    }
}
