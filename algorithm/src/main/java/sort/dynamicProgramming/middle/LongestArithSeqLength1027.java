package sort.dynamicProgramming.middle;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
 *
 * 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。
 *
 */
public class LongestArithSeqLength1027 {

    @Test
    public void test01(){
        int[] nums = {0,1,2,3,4,5,6};
        longestArithSeqLength(nums);
    }

    public int longestArithSeqLength(int[] A) {
        int len = A.length;
        if (len == 0) return 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        int res = 1;

        for (int i = 0; i < len; i++) {
            map.put(i, new HashMap<>());
            for (int j = i - 1; j >= 0; j--) {
                if (map.get(i).containsKey(A[i] - A[j])) continue;
                int cur = map.get(j).getOrDefault(A[i] - A[j], 0);
                res = Math.max(res, cur + 2);
                map.get(i).put(A[i] - A[j], cur + 1);
            }
        }
        return res;
    }
}
