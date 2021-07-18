package org.example.leetcode.dp.array;

/**
 * 152. 乘积最大子数组 https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * 参考：https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
 *
 * @author lichuan
 */
public class MaxProductProblem {
    /**
     * 核心思想：由于存在负数，那么会导致最大的变最小的，最小的变最大的。
     */
    public int maxProduct(int[] nums) {
        int max = nums[0], imax = 1, imin = 1;
        for (int num : nums) {
            if (0 > num) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(imax * num, num);
            imin = Math.min(imin * num, num);

            //此处去max于imax的最大值
            max = Math.max(max, imax);
        }

        return max;
    }

    public static double maxProduct(double[] arr) {
        double max = arr[0], imax = 1.0, imin = 1.0;
        for (double d : arr) {
            if (0 > d) {
                double temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(imax * d, d);
            imin = Math.min(imin * d, d);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(Double.MIN_VALUE > 0) ;
    }
}
