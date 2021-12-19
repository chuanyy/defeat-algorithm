package org.example.leetcode.array;

/**
 * NC30 数组中未出现的最小正整数
 * https://www.nowcoder.com/practice/8cc4f31432724b1f88201f7b721aa391?tpId=190&&tqId=35388&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class MinNumberdisapperedProblem {

    /**
     * 其实这个题目不太严谨，本质上是一个简单的数学问题。
     * 应该再加上一个条件：加上这个缺失的最小整数后，它是一个连续数组（不包括0）
     *
     * 先求出数组和，然后再计算出[min, max]连续区间的和。差值就是缺少的那个正数。
     */
    public int minNumberdisappered (int[] arr) {
        //数字范围的左右边界
        int lMin = arr[0], rMax = arr[0];
        int sum1 = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (lMin > arr[i]) {
                lMin = arr[i];
            }
            if (rMax < arr[i]) {
                rMax = arr[i];
            }

            sum1 += arr[i];
        }

        int sum2 = 0;
        for (int i = lMin; i < rMax; i++) {
            sum2 += i;
        }
        int loss = sum2 - sum1 == 0 ? rMax + 1 : sum2 - sum1;

        return Math.max(1, loss);
    }
}
