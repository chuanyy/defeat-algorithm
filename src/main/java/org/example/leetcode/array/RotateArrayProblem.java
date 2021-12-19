package org.example.leetcode.array;

/**
 *  旋转数组 https://leetcode-cn.com/problems/rotate-array/
 *
 *  参考 ：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
 *
 * @author lichuan
 */
public class RotateArrayProblem {
    /**
     * 方法一： 使用额外的数组
     *
     * 用 n 表示数组的长度，我们遍历原数组，将原数组下标为 i 的元素放至新数组下标为 (i+k)mod n的位置，
     * 最后将新数组拷贝至原数组即可
     *
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i + k) % n] = nums[i];
        }

        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
