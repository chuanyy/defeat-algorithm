package org.example.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * 以升序排列为例：将第一个元素和第二个元素比较，若前者大于后者，则交换两者的位置，再将第二个元素与第三个元素比较，若前者大于后者则交换两者位置，
 * 以此类推直到倒数第二个元素与最后一个元素比较，若前者大于后者，则交换两者位置。这样一轮比较下来将会把序列中最大的元素移至序列末尾，
 * 这样就安排好了最大数的位置，接下来只需对剩下的（n-1）个元素，重复上述操作即可。
 *
 * 时间复杂度：
 * 若原数组本身就是有序的（这是最好情况），仅需n-1次比较就可完成，时间复杂度依然为O(n）；
 * 若是倒序，比较次数为 n-1+n-2+...+1=n(n-1)/2，交换次数和比较次数等值。所以，其时间复杂度依然为O(n2）
 *
 * 空间复杂度：
 * 使用常数个辅助单元：O(1）
 *
 * @author lichuan
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return arr;
        }

        int length = arr.length;
        //外层循环用来记录第i轮冒泡，n个数，需要n-1轮
        //每轮冒泡中都会找到剩下length - i + 1个数中的最大值
        for (int i = 1; i <= length - 1; i++) {
            //内层循环，用来找到每轮冒泡中的最大数值
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =  temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 1, 3};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
