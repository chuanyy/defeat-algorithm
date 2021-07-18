package org.example.leetcode.dp.array;

import java.util.Arrays;

/**
 * 300. 最长递增子序列 https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * 参考：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 *
 * @author lichuan
 */
public class LengthOfLISProblem {

    /**
     * 方法一：动态规划
     */
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        //dp[i]表示以索引为i结尾的最长子序列长度
        int[] dp = new int[nums.length];
        int res = 0;
        //初始化
        //dp[i] 所有元素置 1，含义是每个元素都至少可以单独成为子序列，此时长度都为 1。
        Arrays.fill(dp, 1);
        //状态转移方程
        //dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        if (null == nums) {
            return 0;
        }
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        // tail[i] 数组的定义：长度为 i 的上升子序列的末尾最小数字
        int[] tail = new int[len + 1];
        // 遍历第 1 个数，直接放在有序数组 tail 索引为1的位置
        tail[1] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end =1;

        for (int i = 1; i < len; i++) {
            // 【逻辑 1】比 tail 数组实际有效的末尾的那个元素还大
            if (nums[i] > tail[end]) {
                // 直接添加在那个元素的后面，所以 end 先加 1
                end++;
                tail[end] = nums[i];
            } else {
                // 使用二分查找法，在有序数组 tail 中
                // 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                int left = 1;
                int right = end;
                while (left < right) {
                    // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                    // int mid = left + (right - left) / 2;
                    int mid = left + ((right - left) >>> 1);
                    if (tail[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = nums[i];
            }

        }
        return end;
    }


    /**
     * NC91 最长递增子序列 https://www.nowcoder.com/practice/9cf027bf54714ad889d4f30ff0ae5481?tpId=190&&tqId=35211&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     *
     * 参考：https://blog.csdn.net/qq_44688635/article/details/115470259
     */
    public int[] lengthOfLISNewCoder(int[] arr) {
        if (null == arr) {
            return null;
        }
        int len = arr.length;
        if (len <= 1) {
            return arr;
        }

        // tail[i] 数组的定义：长度为 i 的上升子序列的末尾最小数字
        int[] tail = new int[len + 1];
        // 遍历第 1 个数，直接放在有序数组 tail 索引为1的位置
        tail[1] = arr[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 1;

        // 表示以arr[i]为结尾的递增子序列的最大长度
        int[] maxLen = new int[len];
        //显然以arr[0]为结尾的递增子序列的最大长度1
        maxLen[0] = 1;

        for (int i = 1; i < len; i++) {
            // 【逻辑 1】比 tail 数组实际有效的末尾的那个元素还大
            if (arr[i] > tail[end]) {
                // 直接添加在那个元素的后面，所以 end 先加 1
                end++;
                tail[end] = arr[i];
                maxLen[i] = end;
            } else {
                // 使用二分查找法，在有序数组 tail 中
                // 找到第 1 个大于等于 arr[i] 的元素，尝试让那个元素更小
                int left = 1;
                int right = end;
                while (left < right) {
                    // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                    // int mid = left + (right - left) / 2;
                    int mid = left + ((right - left) >>> 1);
                    if (tail[mid] < arr[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = arr[i];
                maxLen[i] = left;
            }

        }

        //存储最长递增子序列
        int[] res = new int[end];
        //赋值索引
        int curLen = end;
        /*
            从maxLen数组的末尾开始向前遍历，分别将
            maxLen = curLen (len, len - 1, len - 2 ... 1)的元素
            添加到res的指定位置中。

            之所以从后向前遍历，是因为如果有多个maxLen相同的元素，则要得到
            字典序较小的那个。
            反证：
            我们可以看到，当 maxLen[i] == maxLen[i - n] && arr[i] > arr[i - n] 时，
            因为arr[i] > arr[i - n]构成递增，则maxLen[i] > maxLen[i - n]是必然的，
            与我们的条件相违背。所以，从后往前遍历，我们始终能够得到maxLen相等的元素中
            最小的那一个。
         */
        for (int i = arr.length - 1; i >= 0; i--){
            if(maxLen[i] == curLen){
                res[--curLen] = arr[i];
            }
        }
        return res;
    }
}
