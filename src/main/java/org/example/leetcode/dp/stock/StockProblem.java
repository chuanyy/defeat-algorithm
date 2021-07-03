package org.example.leetcode.dp.stock;

/**
 * 动态规划解决股票类型问题
 *
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
 */
public class StockProblem {


    /**
     * 121. 买卖股票的最佳时机
     * 剑指 Offer 63. 股票的最大利润
     * 
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     * 参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/bao-li-mei-ju-dong-tai-gui-hua-chai-fen-si-xiang-b/
     */
    public int maxProfit121(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int length = prices.length;

        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, -prices[i]);
        }

        //如果在最后一天（第n-1天）结束之后，手上仍持有股票，那么显然时没有意义的
        return dp0;
    }

    /**
     * 122. 买卖股票的最佳时机2
     *
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     * 参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
     */
    public int maxProfit122(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int length = prices.length;

        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }

        //如果在最后一天（第n-1天）结束之后，手上仍持有股票，那么显然时没有意义的
        return dp0;
    }

    /**
     * 123. 买卖股票的最佳时机3
     *
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
     * 参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-iii-by-wrnt/
     */
    public int maxProfit123(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int length = prices.length;

        int buy1 = -prices[0], buy2 = -prices[0];
        int sell1 = 0, sell2 = 0;
        for (int i = 1; i < length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }

        //在状态转移的过程中我们维护的是最大值
        return sell2;
    }

    /**
     * 309. 最佳买卖股票时机含冷冻期
     *
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     * 参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
     */
    public int maxProfit309(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        //此处注意时从第0天开始的
        int dp0 = -prices[0];
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp2 - prices[i]);
            dp1 = dp0 + prices[i];
            dp2 = Math.max(dp1, dp2);
        }

        //如果在最后一天（第n-1天）结束之后，手上仍持有股票，那么显然时没有意义的
        return Math.max(dp1, dp2);
    }


    /**
     * 714. 买卖股票的最佳时机含手续费
     *
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
     * 参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-han-sh-rzlz/
     */
    public int maxProfit714(int[] prices, int fee) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        int length = prices.length;

        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i] - fee);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }

        //如果在最后一天（第n-1天）结束之后，手上仍持有股票，那么显然时没有意义的
        return dp0;
    }
}
