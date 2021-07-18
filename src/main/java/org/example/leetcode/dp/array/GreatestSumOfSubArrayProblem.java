package org.example.leetcode.dp.array;

/**
 * NC67 连续子数组的最大和 https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=190&&tqId=35198&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 * NC19 子数组的最大累加和问题 https://www.nowcoder.com/practice/554aa508dd5d4fefbf0f86e5fe953abd?tpId=190&&tqId=35386&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 * @author lichuan
 */
public class GreatestSumOfSubArrayProblem {
    public int FindGreatestSumOfSubArray(int[] arr) {
        if(null == arr || arr.length == 0) {
            return 0;
        }
        int length = arr.length;
//        dp[i]表示前i个数中连续子数组的最大和
        int[] dp = new int[length + 1];
//        初始化;
        dp[0] =0;
//         最大值初始化为数组第一个元素。一定不能初始化为0，当数组全部为负数时，计算会出错
        int maxSum = arr[0];
        for (int i = 1; i <= length; i++) {
            dp[i] = Math.max(arr[i - 1], dp[i - 1] + arr[i - 1]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
