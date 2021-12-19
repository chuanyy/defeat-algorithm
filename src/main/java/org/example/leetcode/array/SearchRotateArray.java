package org.example.leetcode.array;


/**
 * 33. 搜索旋转排序数组 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 同NC48 在旋转过的有序数组中寻找目标值
 *
 * @author lichuan
 */
public class SearchRotateArray {
    public static int search(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            //在有序的半段里二分查找
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <=nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        search(nums, 1);

    }
}
