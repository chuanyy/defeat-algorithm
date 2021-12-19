package org.example.leetcode.array;

import java.util.Arrays;
import java.util.Objects;

/**
 * 最大、最小数问题
 *
 * @author lichuan
 */
public class LargestNumberPrblem {

    /**
     * 179. 最大数 https://leetcode-cn.com/problems/largest-number/
     *
     * 参考：https://leetcode-cn.com/problems/largest-number/solution/java-jiang-shu-zu-zhuan-hua-wei-zi-fu-ch-ikrv/
     *     https://leetcode-cn.com/problems/largest-number/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-vn86e/
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        if (null == nums || nums.length < 1) {
            return "0";
        }

        //将int数组转换为字符串数组
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        //通过比较(a+b)和(b+a)的大小，就可以判断出a,b两个字符串谁应该在前面
        //降序排列
        Arrays.sort(numStrs, (a, b) -> (b+a).compareTo(a+b));

        //如果降序后第一个元素为0.则后面的元素肯定小于或等于0.可直接返回0
        if (Objects.equals(numStrs[0], "0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : numStrs) {
            sb.append(str);
        }

        return sb.toString();
    }

    /**
     * 剑指 Offer 45. 把数组排成最小的数  https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
     */
    public String minNumber(int[] nums) {
        if (null == nums || nums.length < 1) {
            return "0";
        }

        //将int数组转换为字符串数组
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        //通过比较(a+b)和(b+a)的大小，就可以判断出a,b两个字符串谁应该在前面
        //升排列
        Arrays.sort(numStrs, (a, b) -> (a+b).compareTo(b+a));

        StringBuilder sb = new StringBuilder();
        for (String str : numStrs) {
            sb.append(str);
        }

        return sb.toString();
    }
}
