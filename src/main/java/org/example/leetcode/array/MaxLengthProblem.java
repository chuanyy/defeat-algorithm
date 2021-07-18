package org.example.leetcode.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 牛客网 NC41 最长无重复子数组 https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=190&&tqId=35220&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 *
 */
public class MaxLengthProblem {

    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        if(null == arr || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                /*  当某个数在之前出现过，这个时候就把子串的起点start往后推一个，但是有一种情况，
                    比如1，2，3，4，3，5，1。到第二个3时，以后的子串起点start为4，
                    到第二个1时，如果不取最大的start，按start = map.get(arr[end])+1
                    算出起点start为2，显然以起点start=2，结尾end=1的子串234351有重复的，
                    因此start要取最大的
                */
                j = Math.max(j, map.get(arr[i]) + 1);
            }
            map.put(arr[i], i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    /**
     *  用队列实现
     */
    public int maxLength2 (int[] arr) {
        if(null == arr || arr.length == 0) {
            return 0;
        }
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i : arr) {
            //如果有重复的，队头出队
            while (queue.contains(i)) {
                queue.poll();
            }

            //添加到队列尾部
            queue.add(i);
            res = Math.max(res, queue.size());
        }

        return res;
    }
}
