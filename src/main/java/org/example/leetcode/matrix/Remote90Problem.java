package org.example.leetcode.matrix;

/**
 * 面试题 01.07. 旋转矩阵 https://leetcode-cn.com/problems/rotate-matrix-lcci/
 *
 * NC18 顺时针旋转矩阵 https://www.nowcoder.com/practice/2e95333fbdd4451395066957e24909cc?tpId=190&&tqId=35208&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 */
public class Remote90Problem {


    /**
     * 方法一：使用一个额外数据
     *
     * 旋转后的数组满足以下公式
     * mat[j][n-1-i] = mat[i][j]
     */
    public int[][] rotateMatrix(int[][] mat, int n) {
        if (null == mat || mat[0].length < 1 || n < 1) {
            return null;
        }

        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n - 1 - i] = mat[i][j];
            }
        }

        return res;
    }

    /**
     * 方法二：原地转换
     */
    public int[][] rotateMatrix2(int[][] mat, int n) {
        if (null == mat || mat[0].length < 1 || n < 1) {
            return null;
        }

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2; j++) {
                // 临时变量保存mat[j][n-1-i]
                int tmp = mat[j][n-1-i];
                // 进行4次交换
                mat[j][n-1-i] = mat[i][j];
                mat[i][j] = mat[n-1-j][i];
                mat[n-1-j][i] = mat[n-1-i][n-1-j];
                mat[n-1-i][n-1-j] = tmp;
            }
        }

        return mat;
    }
}
