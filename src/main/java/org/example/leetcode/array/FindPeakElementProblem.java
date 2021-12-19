package org.example.leetcode.array;

/**
 * 寻找峰值
 *
 * @author lichuan
 */
public class FindPeakElementProblem {

    /**
     * 162. 寻找峰值 https://leetcode-cn.com/problems/find-peak-element/
     * //从前往后找索引最小的一个
     *
     * 参考：https://leetcode-cn.com/problems/find-peak-element/solution/xun-zhao-feng-zhi-by-leetcode/
     *
     */
    public int findPeakElement(int[] nums) {
        if(null == nums || nums.length <= 0) {
            return -1;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return nums.length - 1;
    }

    /**
     * 递归二分查找
     */
    public int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, l, mid);
        }
        return search(nums, mid + 1, r);
    }

    /**
     * 迭代 二分
     */
    public int findPeakElement3(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r -l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }



    /**
     * NC107 寻找峰值 https://www.nowcoder.com/practice/1af528f68adc4c20bf5d1456eddb080a?tpId=190&&tqId=35434&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     * 从后往前找索引最大的一个
     */
    public int solve (int[] a) {
        if(null == a || a.length <= 0) {
            return -1;
        }
        for (int i = a.length - 1; i > 1; i--) {
            if (a[i] > a[i- 1]) {
                return i;
            }
        }

        return 0;
    }
}
