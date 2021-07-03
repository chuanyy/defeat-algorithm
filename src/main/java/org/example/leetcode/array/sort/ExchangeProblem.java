package org.example.leetcode.array.sort;

/**
 *
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 *
 * 参考 https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/solution/ti-jie-shou-wei-shuang-zhi-zhen-kuai-man-shuang-zh/
 */
public class ExchangeProblem {
    /**
     * 方法一：首尾指针法
     */
    public int[] exchange(int[] nums) {
        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            if ((nums[head] & 1) == 1) {
                head++;
                continue;
            }
            if ((nums[tail] & 1) == 0) {
                tail--;
                continue;
            }

            int temp = nums[head];
            nums[head++] = nums[tail];
            nums[tail--] = temp;
        }

        return nums;
    }


    /**
     * 方法一：快慢指针法
     */
    public int[] exchange2(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1) {
                int temp = nums[slow];
                nums[slow++] = nums[fast];
                nums[fast++] = temp;
            } else {
                fast++;
            }
        }

        return nums;
    }
}
