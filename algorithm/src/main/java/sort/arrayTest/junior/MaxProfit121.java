package sort.arrayTest.junior;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 */
public class MaxProfit121 {

    public int maxProfit(int[] prices) {
        int minPrince = Integer.MAX_VALUE;
        int fit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrince) {
                minPrince = prices[i];
            }
            if (prices[i] - minPrince > fit) {
                fit = prices[i] - minPrince;
            }
        }
        return fit;
    }
}
