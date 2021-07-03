package org.example.leetcode.dp.array;

/**
 *   剑指 Offer 42. 连续子数组的最大和
 *   https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 *
 */
public class MaxSubArrayProblem {
    //动态规划+空间优化
    public int maxSubArray(int[] nums) {

        if(null == nums || nums.length == 0) {
            return 0;
        }

        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(nums[i], res);
        }

        return res;
    }
}
