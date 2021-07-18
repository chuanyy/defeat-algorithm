package org.example.leetcode.dp.array;

/**
 * NC144 不相邻最大子序列和 https://www.nowcoder.com/practice/269b4dbd74e540aabd3aa9438208ed8d?tpId=190&&tqId=37969&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class IntervalSubsequenceProblem {
    /**
     * 其实就是一个打家劫舍的问题，数组中每一个元素值就是可以偷的金额，相邻的不能偷，求能够偷出的最大金额是多少。
     *
     * 设置一个状态转移数组dp，dp[i]表示数组中前i个元素所能偷的最大金额是多少
     *
     * 状态转移表达式：
     * (1)对于当前的元素arr[i],如果偷，那么dp[i] = dp[i-2] + arr[i]
     * (2)如果不偷，那么dp[i] = dp[i-1]
     *
     * @param n int整型 数组的长度
     * @param array int整型一维数组 长度为n的数组
     * @return long长整型
     */
    public long subsequence (int n, int[] array) {
        if(0 >= n || null == array || 0 == array.length) {
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = array[0];
        for (int i = 2; i <=n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i - 1]);
        }

        return dp[n];
    }
}
