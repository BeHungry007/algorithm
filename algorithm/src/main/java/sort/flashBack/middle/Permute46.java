package sort.flashBack.middle;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class Permute46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    @Test
    public void test0(){
        int[] nums = {1,2,3};
        permute1(nums);

    }
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res, output, 0, used, path);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> output, int i, boolean[] used, Deque<Integer> path) {
        if (i == output.size()) {
            res.add(new ArrayList<>(path));
        }
        for (int j = 0; j < output.size(); j++) {
            if (used[j]) {
                continue;
            }
            path.addLast(output.get(j));
            used[j] = true;
            dfs(res, output, i + 1, used, path);
            used[j] = false;
            path.removeLast();
        }
    }
}

