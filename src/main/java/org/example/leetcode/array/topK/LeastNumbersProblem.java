package org.example.leetcode.array.topK;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数 https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * <p>
 * 参考：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/
 * @author lichuan
 */
public class LeastNumbersProblem {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k <= 0 || null == input) {
            return new  ArrayList<>(0);
        }

        // 最后一个参数表示我们要找的是下标为k-1的数
        int[] topK = quickSearch(input, 0, input.length - 1, k - 1);
        ArrayList<Integer> result = new ArrayList<>(topK.length);
        Arrays.stream(topK).forEach(result::add);
        return result;
    }

    /**
     * 牛客网 https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf?tpId=190&&tqId=35209&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
     */
    public int findKth(int[] a, int n, int K) {
        int[] topK = quickSearch(a, 0, n - 1, K - 1);
        return topK[K - 1];
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
        //找到枢轴位置
        while (true) {
            while (++low <= right && arr[low] < pivot) ;
            while (--high >= left && arr[high] > pivot) ;
            if (high <= low) {
                break;
            }

            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
        }

        //将pivot放在枢轴的位置上个
        arr[left] = arr[high];
        arr[high] = pivot;

        return high;
    }
}
