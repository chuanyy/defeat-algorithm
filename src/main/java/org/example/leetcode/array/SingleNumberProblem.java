package org.example.leetcode.array;

import java.util.Arrays;

/**
 * 只出现一次的的数字
 *
 * @author lichuan
 */
public class SingleNumberProblem {

    /**
     * 136. 只出现一次的数字
     * https://leetcode-cn.com/problems/single-number/
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    /**
     * NC156 数组中只出现一次的数（其它数出现k次）
     * https://www.nowcoder.com/practice/5d3d74c3bf7f4e368e03096bb8857871?tpId=190&&tqId=38218&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     */
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param arr int一维数组
     * @param k int
     * @return int
     */
    public int foundOnceNumber (int[] arr, int k) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            //如果相邻元素相等，则将指针向后移动k-1位
            if (arr[i] == arr[i + 1]) {
                i += k -1;
            } else {
                return arr[i];
            }
        }
        return arr[arr.length - 1];
    }
}
