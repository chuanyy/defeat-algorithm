package org.example.sort;

import java.util.Arrays;

/**
 * 排序
 * 插入排序
 * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。
 * 初始已排序区间只有一个元素，就是数组的第一个元素。
 * 插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序。
 * 重复这个过程，直到未排序区间中元素为空，算法结束。
 */
public class InsertSortProblem {
    public static void insertSort(int[] nums) {
        if(null == nums || nums.length == 0) {
            return;
        }
        int length = nums.length;
        for (int i = 1, j; i < length; i++) {
            //当前需要插入的数
            int num = nums[i];
            //大于当前值的数后移，找到插入位置
            for (j = i - 1; j >= 0 && nums[j] > num; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = num;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
