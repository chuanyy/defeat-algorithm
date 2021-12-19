package org.example.leetcode.matrix;

/**
 * 面试题 10.09. 排序矩阵查找 https://leetcode-cn.com/problems/sorted-matrix-search-lcci/
 *
 * NC86 矩阵元素查找 https://www.nowcoder.com/practice/3afe6fabdb2c46ed98f06cfd9a20f2ce?tpId=190&&tqId=35380&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * 从矩阵的左下角开始，因为每行每列都是有序的。
 * @author lichuan
 */
public class SearchMatrixProblem {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || matrix.length < 1) {
            return false;
        }

        int x = matrix.length - 1;
        int y = 0;
        while (x >= 0 && y <= matrix[0].length) {
            if (matrix[x][y] == target) {
                return true;
            }
            else if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }

        return false;
    }

    public int[] findElement(int[][] mat, int n, int m, int x) {
        if(null == mat || mat.length < 1) {
            return new int[]{};
        }

        int r = mat.length - 1;
        int c = 0;
        while (r >= 0 && c <= mat[0].length) {
            if (mat[r][c] == x) {
                return new int[]{r, c};
            }
            else if (mat[r][c] > x) {
                r--;
            } else {
                c++;
            }
        }

        return new int[]{};
    }
}
