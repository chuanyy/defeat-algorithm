package org.example.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=190&&tqId=35361&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class TwoSumProblem {
    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (cache.containsKey(target - numbers[i])) {
                result[0] = cache.get(target -numbers[i]) + 1;
                result[1] = i + 1;
            }

            cache.put(numbers[i], i);
        }

        return result;
    }
}
