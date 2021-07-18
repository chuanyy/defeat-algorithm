package org.example.leetcode.dp.stock;

/**
 * 动态规划解决股票类型问题
 *
 * 参考 https://leetcode-cn.com/circle/article/qiAgHn/
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
        if (null == prices || prices.length < 2) {
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
        if (null == prices || prices.length < 2) {
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
    public int maxProfit123LiJie(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        //dp[i][j][0]表示第i天结束时，最多进行k次操作后，手里不持股的最大收益
        //dp[i][j][1]表示第i天结束时，最多进行k次操作后，手里持1份股的最大收益
        int[][][] dp = new int[length][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
        }

        return dp[length - 1][2][0];
    }

    public int maxProfit123(int[] prices) {
        if (null == prices || prices.length < 2) {
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
     *
     * 188. 买卖股票的最佳时机 IV https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
     */
    public int maxProfit188(int k, int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        if (k > length / 2) {
            return maxProfit122(prices);
        }
        int[][][] dp = new int[length][k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <=k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[length - 1][k][0];
    }

    /**
     * 309. 最佳买卖股票时机含冷冻期
     *
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     * 参考：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/zui-jia-mai-mai-gu-piao-shi-ji-han-leng-dong-qi-4/
     */

    public int maxProfit309LiJie(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //在有「冷却时间」的情况下，如果在第 i - 1 天卖出了股票，就不能在第 i 天买入股票。
            // 因此，如果要在第 i 天买入股票，第二个状态转移方程中就不能使用 T[i - 1][k][0]，
            // 而应该使用 T[i - 2][k][0](因为第i天要买入股票，所以第i-1天不能持有股票;又因为右冷却期，所以第i-1天不能卖出股票。
            // 因此只能是第i-2天不持股：卖出或不持股)
            //
            dp[i][1] = Math.max(dp[i - 1][1], (i >= 2 ? dp[i - 2][0] : 0) - prices[i]);
        }
        return dp[length - 1][0];
    }

    public int maxProfit309(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        //此处注意时从第0天开始的
        int prevProfit0 = 0, profit0 = 0, profit1 = -prices[0];
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            int nextProfit0 = Math.max(profit0, profit1 + prices[i]);
            int nextProfit1 = Math.max(profit1, prevProfit0 - prices[i]);
            prevProfit0 = profit0;
            profit0 = nextProfit0;
            profit1 = nextProfit1;
        }
        return profit0;
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
