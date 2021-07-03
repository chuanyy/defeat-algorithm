package org.example.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子 https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 *
 * 参考： https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
 * @author lichuan
 */
public class IsStraightProblem {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        int max = 0, min =  14;
        for (Integer num : nums) {
            //跳过大小王
            if (0 == num) {
                continue;
            }
            // 若有重复，提前返回 false
            if (set.contains(num)) {
                return false;
            }

            set.add(num);
            //最大牌
            max = Math.max(max, num);
            //最小牌
            min = Math.min(min, num);
        }

        return max - min < 5;
    }

    public boolean isStraight2(int[] nums) {
        int joker = 0;
        // 数组排序
        Arrays.sort(nums);
        for(int i = 0; i < 4; i++) {
            // 统计大小王数量
            if(nums[i] == 0) {
                joker++;
            }
            // 若有重复，提前返回 false
            else if(nums[i] == nums[i + 1]) {
                return false;
            }
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4] - nums[joker] < 5;
    }
}
