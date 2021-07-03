package org.example.leetcode.array.topK;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数 https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * <p>
 * 参考：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/
 */
public class LeastNumbersProblem {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int low, int high, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, low, high);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, low, j - 1, k) : quickSearch(nums, j + 1, high, k);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int low = left, high = right + 1;
        while (true) {
            while (++low <= right && arr[low] < pivot) ;
            //此处不能加=，会越界
            while (--high >= left && arr[high] > pivot) ;
            if (high <= low) {
                break;
            }

            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }

        arr[left] = arr[high];
        arr[high] = pivot;

        return high;
    }
}
