package org.example.leetcode.bitoperation;

/**
 * 剑指 Offer 15. 二进制中1的个数 https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 *
 * 参考：https://leetcode-cn.com/problems/number-of-1-bits/solution/fu-xue-ming-zhu-xiang-jie-wei-yun-suan-f-ci7i/
 *
 * @author lichuan
 */
public class HammingWeightProblem {

    public int hammingWeight(int n) {
        int result =0;
        while (n != 0) {
            n = n & (n - 1);
            result++;
        }
        return result;
    }
}
