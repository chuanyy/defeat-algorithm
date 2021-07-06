package org.example.leetcode.dp;

public class JumpFloorProblem {

    /**
     * 使用递归中间会有许多重复计算
     */
    public int jumpFloor(int target) {
        if (target <= 1) {
            return 1;
        }

        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    /**
     * 使用动态规划的思想去掉重复计算
     */
    public int jumpFloor2(int target) {

        int a = 1, b = 1;
        for (int i = 2; i <= target; i++) {
            //理解为f(n)
            a = a + b;
            //理解为f(n - 1)
            b = a - b;
        }

        return a;
    }
}
