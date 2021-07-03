package sort.dynamicProgramming.middle;

/**
 * 数组 A 包含 N 个数，且索引从0开始。
 * 数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 *
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 *
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 *
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 *
 */
public class NumberOfArithmeticSlices413 {

    /**
     * 题解：  子数组为连续，满足条件最低的个数为3！
     *      1. 遍历数组，因为最低数量为3，所以从index=2开始遍历（index的位置为Q的位置）
     *      2. 设置dp = 0, sum = 0;
     *      3. 当满足A[index]-A[index-1]==A[index-1]-A[index-2]的时候，
     *          dp加一，sum加dp;（dp可以理解为[q,Q-2]位置参数的数量）
     *              ps:0,2,3,4,5,6   当index为5的时候，dp的数值大小为[2,3]的数量。
     *                               不包括0的位置是因为公差变化，需要固定公差大小。
     *      4. 当不满足条件的时候（即此时公差发生变化，dp需要置为0
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        int dp = 0;
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp = 1 + dp;
                sum += dp;
            } else
                dp = 0;
        }
        return sum;
    }

    int sum = 0;
    public int numberOfArithmeticSlices1(int[] A) {
        slices(A, A.length - 1);
        return sum;
    }
    public int slices(int[] A, int i) {
        if (i < 2)
            return 0;
        int ap = 0;
        if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
            ap = 1 + slices(A, i - 1);
            sum += ap;
        } else
            slices(A, i - 1);
        return ap;
    }


}
