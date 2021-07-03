package org.example.leetcode.array;

/**
 * 剑指 Offer 11. 旋转数组的最小数字 https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * 参考 https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-by-leetcode-s/
 */
public class MinArrayProblem {
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[high] < numbers[pivot]) {
                low = low + 1;
            } else if (numbers[high] > numbers[pivot]) {
                high = pivot;
            } else {
                high--;
            }
        }

        return numbers[low];
    }
}
