package sort.arrayTest.middle;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 *
 * 回溯算法
 *
 */
public class CombinationSum39 {

    @Test
    public void test01(){
        int[] arr = {2,3,6,7};
        combinationSum1(arr, 7);
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);
        dfs1(candidates, 0, len, new ArrayDeque<>(), target, res);
        return res;
    }

    private void dfs1(int[] candidates, int cur, int lens, Deque<Integer> ad, int target, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(ad));
            return;
        }

//        if (cur == lens || target - candidates[cur] < 0) {
//            return;
//        }

        for (int i = cur; i < lens; i++) {

            if (target - candidates[i] < 0) {
                break;
            }

            ad.addLast(candidates[i]);
            dfs1(candidates, i, lens, ad, target - candidates[i], res);
            ad.removeLast();
        }


    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;

        // 排序是为了提前终止搜索
        Arrays.sort(candidates);

        dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     * @param candidates 数组输入
     * @param len        输入数组的长度，冗余变量
     * @param residue    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
    private void dfs(int[] candidates,
                     int len,
                     int residue,
                     int begin,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        if (residue == 0) {
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {

            // 在数组有序的前提下，剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, len, residue - candidates[i], i, path, res);
            path.removeLast();

        }
    }

    private void dfs1(int[] candidates,
                     int len,
                     int residue,
                     int begin,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (begin == candidates.length || residue - candidates[begin] < 0) {
            return;
        }

        dfs1(candidates, len, residue, begin + 1, path, res);

        path.add(candidates[begin]);
        dfs1(candidates, len, residue - candidates[begin], begin, path, res);
        path.removeLast();
    }
}
