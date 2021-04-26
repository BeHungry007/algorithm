package sort.flashBack.middle;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 */
public class PremuteUnique47 {

    @Test
    public void test01(){
        String s = "aaa";
        System.out.println(s.charAt(0) == s.charAt(1));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        int[] nums = {1,2,1};
        permuteUnique(nums);
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        Arrays.sort(nums);
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
            if (used[j] || (j > 0 && output.get(j) == output.get(j - 1))) {
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
