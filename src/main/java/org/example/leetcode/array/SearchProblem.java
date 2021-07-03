package org.example.leetcode.array;

import java.util.Arrays;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * 参考：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/mian-shi-ti-53-i-zai-pai-xu-shu-zu-zhong-cha-zha-5/
 * @author lichuan
 */
public class SearchProblem {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    private int helper(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (target >= nums[pivot]) {
                left = pivot + 1;
            }else {
                right = pivot - 1;
            }
        }

        return left;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = helper(nums, target - 1);
        int right = helper(nums, target) - 1;
        if (left <= right) {
            res[0] = left;
            res[1] = right;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(null == null);
    }
}
