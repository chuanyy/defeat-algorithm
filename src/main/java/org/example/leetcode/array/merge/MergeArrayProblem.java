package org.example.leetcode.array.merge;

import java.util.Arrays;

public class MergeArrayProblem {

    /**
     * 88. 合并两个有序数组
     *
     * https://leetcode-cn.com/problems/merge-sorted-array/
     *
     * 参考：https://leetcode-cn.com/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetcode/
     */
    //方法一:合并后排序
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    //方法二:从前往后
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //拷贝一份nums1
        int[] tempNums1 = new int[m];
        System.arraycopy(nums1, 0, tempNums1, 0, m);

        //双指针
        int p1 = 0, p2 = 0;
        //合并后的位置
        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (tempNums1[p1] < nums2[p2]) ? tempNums1[p1++] : nums2[p2++];
        }

        if (p1 < m) {
            System.arraycopy(tempNums1, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    //方法二:从后往前
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        //双指针
        int p1 = m - 1, p2 = n - 1;
        //合并后的位置
        int p = m + n - 1;
        while ((p1 >=0 ) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }

        if (p2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }



}


