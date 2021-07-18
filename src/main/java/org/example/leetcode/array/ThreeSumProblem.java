package org.example.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatCodePointException;

/**
 * NC54 数组中相加和为0的三元组 https://www.nowcoder.com/practice/345e2ed5f81d4017bbb8cc6055b0b711?tpId=190&&tqId=35196&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class ThreeSumProblem {
    /**
     * 思路：
     * （1）首先对数组进行排序（从小到大）
     * （2）依次取出第 i 个数（i从0开始），并且不重复的选取（跳过重复的数）
     * （3）这样问题就转换为 2 个数求和的问题（可以用双指针解决方法）
     * ==》数求和问题
     * （4）定义两个指针：左指针（left） 和 右指针（right）
     * （5）找出固定 left， 此时left所指的位置为数组中最小数，再找到两个数和 不大于 target 的最大 right 的位置
     * （6）调整 left 的位置（后移），求解和是否为 target O(n)
     * ==》时间复杂度：O(nlogn) + O(n)
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (null == num || num.length < 2) {
            return result;
        }

        //先按升序排序
        Arrays.sort(num);
        //因为要求三个数，所以此i最大为num.length - 3
        for (int i = 0; i < num.length - 2; i++) {
            //如果num[i] > 0,则不存在以其开始的三个数之和大于0。结束循环
            if (0 < num[i]) {
                break;
            }
            //如果当前数于前一个数相等，则跳过.从i=1开始判断
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (0 == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[left]);
                    list.add(num[right]);
                    result.add(list);

                    //给第二个数去重
                    while (left < right && num[left] == num[left + 1]) {
                        left++;
                    }

                    //给第二个数去重
                    while (left < right && num[right] == num[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }else if (0 < sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
