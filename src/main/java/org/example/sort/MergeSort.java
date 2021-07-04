package org.example.sort;

/**
 * 归并排序采用的是分治(divide-and-conquer)法思想。
 *
 * 基本思想：将待排序元素分成大小大致相同的2个子集合，分别对2个子集合进行排序，最终将排好序的子集合合并成为所要求的排好序的集合。
 *
 * @author lichuan
 */
public class MergeSort {


    public int[] mergeSort(int[] arr) {
        mergeCore(arr, 0, arr.length - 1);
        return arr;
    }


    public void mergeCore(int[] arr, int left, int right) {
        if (left < right) {
            //计算中间位置
            int mid = left + ((right - left) >> 1);
            //递归左子区间
            mergeCore(arr, left, mid);
            //递归右子区间
            mergeCore(arr, mid + 1, right);
            //合并左右子区间
            merge(arr, left, mid, right);
        }
    }



    /**
     * 合并两个子区间
     */
    public void merge(int[] arr, int left, int mid, int right) {
        //辅助数组
        int[] temp = new int[right - left + 1];
        int start1 = left, end1 = mid;
        int start2 = mid + 1, end2 = right;

        //遍历左右两个子区间，按递增的顺序插入辅助数组
        int index = 0;
        while (start1 <= end1 && start2 <= end2) {
            temp[index++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }

        //start1没有越界，说明start2越界了，将左区间剩余元素全部拷贝到辅助数组
        while (start1 <= end1) {
            temp[index++] = arr[start1++];
        }

        //start2没有越界，说明start1越界了，将右区间剩余元素全部拷贝到辅助数组
        while (start2 <= end2) {
            temp[index++] = arr[start2++];
        }

        //将辅助数组元素拷贝到原数组
        for (int j : temp) {
            arr[left++] = j;
        }
    }

}
