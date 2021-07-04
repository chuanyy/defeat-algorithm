package org.example.sort;

/**
 * 快速排序的基本思想是：
 *
 * 在待排序的元素任取一个元素作为基准(通常选第一个元素，但最佳的选择方法是从待排序元素中随机选取一个作为基准)，称为基准元素；
 * 将待排序的元素进行分区，比基准元素大的元素放在它的右边，比其小的放在它的左边；
 * 对左右两个分区重复以上步骤直到所有元素都是有序的
 *
 * @author lichuan
 */
public class QuickSort {


    public int[] quickSort(int[] arr) {
        quickSortCore(arr, 0, arr.length - 1);
        return arr;
    }


    public void quickSortCore(int[] arr, int left, int right) {
        if (left < right) {
            // 分割数组，找到分割点
            int pivot = partition(arr, left, right);
            // 递归调用，对左子数组进行快速排序
            quickSortCore(arr, left, pivot - 1);
            // 递归调用，对右子数组进行快速排序
            quickSortCore(arr, pivot + 1, right);
        }
    }


    public int  partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            swap(arr, left, right);

            while (left < right && arr[left] <= pivot) {
                left++;
            }
            swap(arr, left, right);
        }

        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =  temp;
    }
}
