package org.example.sort;

/**
 * 堆排序
 *
 * 参考 https://blog.csdn.net/allway2/article/details/114093981
 *
 * @author lichuan
 */
public class HeapSort {



    public int[] heapSort(int[] arr) {
        int n = arr.length;
        //建立大根堆
        //从完整二叉树的第一个非叶子节点开始
        for (int i = n / 2 - 1; i >=0; i--) {
            heapAdjust(arr, n, i);
        }

        //进行堆排序，利用堆最大元素删除的原理
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);

            //重新调整堆
            heapAdjust(arr, i, 0);
        }

        return arr;
    }

    /**
     * 一个值往下沉的过程
     *
     * @param arr 原数组
     * @param n 数组元素个数
     * @param i 当前节点索引值
     */
    public void heapAdjust(int[]arr, int n, int i) {
        int largest = i;
        //完整二叉树中左子树节点的索引值
        int left = 2 * i + 1;
        //完整二叉树中右子树节点的索引值
        int right = 2 * i + 2;

        if (left < n && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right < n && arr[largest] < arr[right]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            //继续向下调整
            heapAdjust(arr, n, largest);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println((-1) /2);
    }
}
