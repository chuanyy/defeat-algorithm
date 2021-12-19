package org.example.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuan
 */
public class MaxlenEqualKProblem {

    /**
     * NC125 未排序数组中累加和为给定值的最长子数组长度
     * https://www.nowcoder.com/practice/704c8388a82e42e58b7f5751ec943a11?tpId=190&&tqId=36102&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     *
     */
    /**
     * 假设s(i)是子数组arr[0…i]的累加和,那么s(j)就代表arr[0…j]的累加和，那么可求得arr[j+1…i]=s(i)-s(j)
     * 如果sum-k存在，则取出它首次出现的位置,假设为j，表示arr[0…j]=sum-k=s(j)。而根据之前的假设arr[j+1…i]=s(i)-s(j),此时sum=s(i),所以arr[j+1…i]=sum-(sum-k)=k。
     * 因为map的value记录的是最早出现的位置，所以此时arr[j+1…i]是以arr[i]结尾的所有子数组中，累加和为k的子数组中最长的，然后更新len。
     */
    public int maxlenEqualK (int[] arr, int k) {
        //非法参数判断
        if(null == arr || arr.length < 1) {
            return 0;
        }

        int maxLen = 0;
        int sum = 0;
        Map<Integer, Integer> sum2FirstIndex = new HashMap<>();
        //根据arr[j+1…i]=s(i)-s(j),所以，如果从0开始遍历，会导致j+1>=1,
        // 这样就会把以arr[0]开始的子数组漏掉了，所以应该从-1位置开始累加，
        // 也就是开始遍历时把(0,-1)加入map，表示如果任何一个数都不加时，累加和为0。
        sum2FirstIndex.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum2FirstIndex.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - sum2FirstIndex.get(sum - k));
            }
            if (!sum2FirstIndex.containsKey(sum)) {
                sum2FirstIndex.put(sum, i);
            }
        }
        return maxLen;
    }
}
