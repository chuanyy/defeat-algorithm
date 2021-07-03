package org.example.leetcode.array;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列 https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 *
 * 参考：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/shi-yao-shi-hua-dong-chuang-kou-yi-ji-ru-he-yong-h/
 */
public class FindContinuousSequenceProblem {
    public int[][] findContinuousSequence(int target) {
        //初始滑动窗口的左右边界均为1
        int i = 1, j = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        //因为序列递增，当i>target / 2时，不存在两个数的和为target
        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
               int[] temp = new int[j - i];
                for (int  k = i; k < j; k++) {
                    temp[k - i] = k;
                }
                res.add(temp);

                sum -= i;
                i++;
            }
        }

        return res.toArray(new int[0][]);
    }
}
