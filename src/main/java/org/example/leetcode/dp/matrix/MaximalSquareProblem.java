package org.example.leetcode.dp.matrix;

/**
 * 221. 最大正方形 https://leetcode-cn.com/problems/maximal-square/
 *
 * 参考 https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
 *
 * @author lichuan
 */
public class MaximalSquareProblem {

    /**
     * 动态规划解法
     */
    public int maximalSquare2(char[][] matrix) {
        //最大边长
        int maxSide = 0;
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) {
            return maxSide;
        }

        int rows = matrix.length, columns = matrix[0].length;
        //dp[i][j]表示以matrix[i][j]为右下角的正方形的最大边长
        int[][] dp = new int[rows][columns];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++) {
                if ('1' == matrix[i][j]) {
                    //以矩阵左边界或上边界元素为右下角的正方形最大边长为1，这个显而易见
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j])) + 1;
                    }

                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

    /**
     * 暴力求解
     */
    public int maximalSquare(char[][] matrix) {
        //最大边长
        int maxSide = 0;
        if (null == matrix || matrix.length == 0 || null == matrix[0] || matrix[0].length == 0) {
            return maxSide;
        }

        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //遇到一个1.作为正方形的左上角
                if ('1' == matrix[i][j]) {
                    //此处来保存边长为1时的情况;
                    maxSide = Math.max(maxSide, 1);
                    //假设可能的最大的正方形边长
                    int currentMaxSide = Math.min(rows - i, columns - j);
                    for (int k = 1; k < currentMaxSide; k++) {
                        // 判断新增的一行一列是否均为 1
                        boolean flag = true;
                        // 先判断右下角
                        if ('0' == matrix[i + k][j + k]) {
                            break;
                        }
                        //在判断新增加的一行和一列（出去右下角）
                        for (int m = 0; m < k; m++) {
                            if ('0' == matrix[i + k][j + m] || '0' == matrix[i + m][j + k]) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            //1代表左上角边长为1的正方形
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }

        }
        return maxSide * maxSide;
    }
}
