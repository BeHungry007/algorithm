package sort.arrayTest.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 *
 */
public class CombinationSum2_40 {

    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int candidate : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || candidate != freq.get(size - 1) [0]) {
                freq.add(new int[]{candidate, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0,target);
        return ans;
    }

    public void dfs(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<>(sequence));
            return;
        }

        if (pos == freq.size() || rest <freq.get(pos)[0]) {
            return;
        }

        dfs(pos + 1, rest);

        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);

        for (int i = 1; i <= most; i++) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }

        for (int i = 1; i <= most; i++) {
            sequence.remove(sequence.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum21(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int candidate : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || candidate != freq.get(size - 1)[0]) {
                freq.add(new int[]{candidate, 1});
            } else {
                freq.get(size - 1)[1] = freq.get(size - 1)[1] + 1;
            }
        }
        dfs1(0, target);
        return ans;
    }

    private void dfs1(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<>(sequence));
            return;
        }

        if (pos == freq.size() ||freq.get(pos)[0] > rest) {
            return;
        }

        dfs1(pos + 1, rest);

        int min = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);

        for (int i = 1; i <= min; i++) {
            sequence.add(freq.get(pos)[0]);
            dfs1(pos, rest - freq.get(pos)[0]);
        }

        for (int i = 1; i <= min; i++) {
            sequence.remove(sequence.size() - 1);
        }

    }

}
