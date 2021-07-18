package org.example.leetcode.dp.matrix;

/**
 * NC59 矩阵的最小路径和 https://www.nowcoder.com/practice/7d21b6be4c6b429bb92d219341c4f8bb?tpId=190&&tqId=35224&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class MinPathSumProblem {
    /**
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum (int[][] matrix) {
        if (null == matrix || null == matrix[0]) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
//        初始化
        dp[0][0] = matrix[0][0];
//        左边界只能左上往下走
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        //        上边界只能左上往右走
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j- 1]) + matrix[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
