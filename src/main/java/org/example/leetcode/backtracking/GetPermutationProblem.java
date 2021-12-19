package org.example.leetcode.backtracking;

import java.util.Arrays;
import java.util.DuplicateFormatFlagsException;

/**
 * 60. 排列序列 https://leetcode-cn.com/problems/permutation-sequence/
 *
 * 参考：https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/578279/
 *
 * 所求排列 一定在叶子结点处得到，进入每一个分支，可以根据已经选定的数的个数，进而计算还未选定的数的个数，然后计算阶乘，就知道这一个分支的 叶子结点 的个数：
 * 如果 k 大于这一个分支将要产生的叶子结点数，直接跳过这个分支，这个操作叫「剪枝」；
 * 如果 k 小于等于这一个分支将要产生的叶子结点数，那说明所求的全排列一定在这一个分支将要产生的叶子结点里，需要递归求解。
 *
 *
 */
public class GetPermutationProblem {

    /**
     * 记录数字是否用过
     */
    private boolean[] used;

    /**
     * 阶乘数组
     */
    private int[] factorial;


    private int n;
    private int k;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;

        initFactorial(n);
        used = new boolean[n + 1];
        Arrays.fill(used, false);

        StringBuilder path = new StringBuilder();
        dfs(0, path);
        return path.toString();
    }


    private void dfs(int index, StringBuilder path) {
        if (n == index) {
            return;
        }

        //计算还未确定的数字的全排列的个数，第1次进入的时候是n-1（因为是在确定第一位数字）
        int count = factorial[n - 1 - index];

        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }

            if (count < k) {
                k = k - count;
                continue;
            }

            path.append(i);
            used[i] = true;
            dfs(index + 1, path);

            //注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            return;
        }
    }


    /**
     * 计算阶乘数组
     */
    private void initFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
}
