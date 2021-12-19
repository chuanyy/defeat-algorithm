package org.example.leetcode.binarysearch;

/**
 * 二分查找
 *
 * @author lichuan
 */
public class binarysearch {

    /**
     * NC105 二分查找-II
     * https://www.nowcoder.com/practice/4f470d1d3b734f8aaf2afb014185b395?tpId=190&&tqId=35227&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     */
    public int banarySearch2(int[] nums, int target) {
        if (null == nums || nums.length < 1) {
            return -1;
        }

        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                while (pivot != 0 && (nums[pivot - 1] == nums[pivot])) {
                    pivot--;
                }
                return pivot;
            } else if (nums[pivot] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return -1;
    }

    /**
     * 704. 二分查找 https://leetcode-cn.com/problems/binary-search/
     */
    public int banarySearch(int[] nums, int target) {
        if (null == nums || nums.length < 1) {
            return -1;
        }

        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return -1;
    }
}
