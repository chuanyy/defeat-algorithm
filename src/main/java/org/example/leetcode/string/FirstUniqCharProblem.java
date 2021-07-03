package org.example.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符 https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FirstUniqCharProblem {
    public char firstUniqChar(String s) {
        if (null == s) {
            return  ' ';
        }
        Map<Character, Integer> char2FrequencyMap = new HashMap<>(s.length());
        for (Character character : s.toCharArray()) {
            char2FrequencyMap.put(character, char2FrequencyMap.getOrDefault(character, 0) + 1);
        }

        //此处不能直接遍历map，因为遍历的结果不一定市安存入顺序
        for (Character character : s.toCharArray()) {
            if (char2FrequencyMap.get(character) == 1) {
                return character;
            }
        }

        return ' ';
    }

    /**
     *  作者：LeetCode-Solution
     *     链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-by-3zqv5/
     *     来源：力扣（LeetCode）
     */
    public char firstUniqChar2(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        return first == n ? ' ' : s.charAt(first);
    }
}
