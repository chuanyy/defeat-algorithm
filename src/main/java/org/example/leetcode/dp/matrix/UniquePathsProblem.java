package org.example.leetcode.dp.matrix;

/**
 * 62. 不同路径 https://leetcode-cn.com/problems/unique-paths/
 *
 * 参考：https://leetcode-cn.com/problems/unique-paths/solution/bu-tong-lu-jing-by-leetcode-solution-hzjf/
 *
 * @author lichuan
 */
public class UniquePathsProblem {
    /**
     * 由于我们每一步只能从向下或者向右移动一步，因此要想走到 (i, j)，如果向下走一步，那么会从 (i-1, j) 走过来；
     * 如果向右走一步，那么会从 (i, j-1) 走过来。因此我们可以写出动态规划转移方程：
     *
     * f(i, j) = f(i-1, j) + f(i, j-1)
     *
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //左边界只能由上往下走，因此只有一种走法
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //上边界只能由左往右走，因此只有一种走法
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
