package org.example.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 剑指 Offer 29. 顺时针打印矩阵 https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 *
 * @author lichuan
 */
public class SpiralOrderProblem {
    public int[] spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return new int[0];
        }
        //定义左右上下边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int[] result = new int[(b + 1) * (r + 1)];
        int index = 0;
        while (true) {
            //从左到右
            for (int i = l; i <= r; i++) {
                result[index++] = matrix[l][i];
            }
            //边界向内收缩（上边界向下），并判断是否越界
            if (++t > b) {
                break;
            }

            //从上到下
            for (int i = t; i <= b; i++) {
                result[index++] = matrix[i][r];
            }
            //边界向内收缩（右边界向左），并判断是否越界
            if (--r <l) {
                break;
            }

            //从右到左
            for (int i = r; i >= l; i--) {
                result[index++] = matrix[b][i];
            }
            //边界向内收缩（下边界向上），并判断是否越界
            if (--b < t) {
                break;
            }

            //从下到上
            for (int i = b; i >= t; i--) {
                result[index++] = matrix[i][l];
            }
            //边界向内收缩（左边界向右），并判断是否越界
            if (++l > r) {
                break;
            }
        }

        return result;
    }

    public ArrayList<Integer> spiralOrder2(int[][] matrix) {
        if (null == matrix || matrix.length == 0) {
            return new ArrayList<>();
        }
        //定义左右上下边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        ArrayList<Integer> result = new ArrayList<>((b + 1) * (r + 1));
        while (true) {
            //从左到右
            for (int i = l; i <= r; i++) {
                result.add(matrix[l][i]);
            }
            //边界向内收缩（上边界向下），并判断是否越界
            if (++t > b) {
                break;
            }

            //从上到下
            for (int i = t; i <= b; i++) {
                result.add(matrix[i][r]);
            }
            //边界向内收缩（右边界向左），并判断是否越界
            if (--r <l) {
                break;
            }

            //从右到左
            for (int i = r; i >= l; i--) {
                result.add(matrix[b][i]);
            }
            //边界向内收缩（下边界向上），并判断是否越界
            if (--b < t) {
                break;
            }

            //从下到上
            for (int i = b; i >= t; i--) {
                result.add(matrix[i][l]);
            }
            //边界向内收缩（左边界向右），并判断是否越界
            if (++l > r) {
                break;
            }
        }

        return result;
    }
}
