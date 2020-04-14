package middleDemo.Demo100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
public class Demo491 {
    @Test
    public void test01(){
        Solution solution = new Solution();
        int[] arr = {4, 6, 7, 8};
        List<List<Integer>> subsequences = solution.findSubsequences(arr);
    }
    class Solution {
        Set<List<Integer>> res;
        int[] nums;
        int n;
        public List<List<Integer>> findSubsequences(int[] nums) {
            this.nums = nums;
            this.n = n;
            res = new HashSet<>();
            helper(new ArrayList<Integer>(), 0);
            return new ArrayList(res);
        }

        void helper(List<Integer> cur, int start) {
            if (cur.size() >= 2) {
                res.add(new ArrayList<Integer>(cur));
                for (Integer integer : cur) {
                    System.out.print(integer + "\t");
                }
                System.out.println();
            }
            for (int i = start; i < nums.length; i ++) {
                if (cur.size() == 0 || cur.get(cur.size() - 1) <= nums[i]) {
                    cur.add(nums[i]);
                    helper(cur, i + 1);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}
