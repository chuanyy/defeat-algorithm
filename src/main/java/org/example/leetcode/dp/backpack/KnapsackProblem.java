package org.example.leetcode.dp.backpack;

/**
 * NC145 01背包 https://www.nowcoder.com/practice/2820ea076d144b30806e72de5e5d4bbf?tpId=190&&tqId=38201&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * 参考 https://blog.csdn.net/qq_38984851/article/details/81133096
 *
 * @author lichuan
 */
public class KnapsackProblem {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算01背包问题的结果
     * @param V int整型 背包的体积
     * @param n int整型 物品的个数
     * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    public int knapsack (int V, int n, int[][] vw) {
//        dp[i][j]以j为容量为放入前i个物品(按i从小到大的顺序)的最大价值。
//        dp[0,j]=dp[i,0]=0
        int[][] dp = new int[n + 1][V + 1];
//        外层循环为物品
        for (int i = 1; i <= n; i++) {
//            内层循环为容量
            for (int  j = 1; j <=V; j++) {
                if (j < vw[i- 1][0]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
//                    还有足够的容量可以装该商品，但装了也不一定达到当前最优价值，所以在装与不装之间选择最优的一个，
//                    即dp[i,j]=max｛ dp[i-1,j]，dp[i-1,j-w[i]]+v[i] ｝其中dp[i-1,j]表示不装，
//                    dp[i-1,j-w[i]]+v[i] 表示装了第i个商品，背包容量减少w[i]但价值增加了v[i]；
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vw[i - 1][0]] + vw[i - 1][1]);
                }
            }
        }
        return dp[n][V];
    }


    /**
     * 空间优化
     */
    public int knapsackOp (int V, int n, int[][] vw) {

        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) {
//          使用一维数组，只能保留上一次循环只有前i个物品的情况下，容量为1..V时的对应的最大价值
//          必须倒着进行更新。如果将v的循环顺序改成顺序的话，那么则成了dp[i][v]由dp[i][v-c[i]]推知，
//          而不是由dp[i-1][v-c[i]]推知，与本题意不符。
//          参考：http://www.manongjc.com/detail/10-fwvgrchpurhwwyp.html
//          只需遍历到剩余容量大于等于背包容量即可
            for (int j = V; j >= vw[i - 1][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - vw[i - 1][0]] + vw[i - 1][1]);
            }
        }
        return dp[V];
    }




}
