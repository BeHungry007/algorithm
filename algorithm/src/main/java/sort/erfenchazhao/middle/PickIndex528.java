package sort.erfenchazhao.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。
 *
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。
 *
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 *
 */
public class PickIndex528 {

    List<Integer> psum = new ArrayList<>();
    private int sum = 0;
    Random rand = new Random();

    public PickIndex528(int[] w) {
        for (int i : w) {
            sum += i;
            psum.add(sum);
        }

    }

    public int pickIndex() {
        int targ = rand.nextInt(sum);
        int left = 0;
        int right = psum.size() - 1;
        while (left != right) {
            int mid = (left + right) / 2;
            if (targ >= psum.get(mid)) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
