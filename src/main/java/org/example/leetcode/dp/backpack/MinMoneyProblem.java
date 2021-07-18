package org.example.leetcode.dp.backpack;

import java.util.Arrays;

/**
 * NC126 换钱的最少货币数 https://www.nowcoder.com/practice/3911a20b3f8743058214ceaa099eeb45?tpId=190&&tqId=36067&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class MinMoneyProblem {

    /**
     * 完全背包问题
     */
    public static int minMoney (int[] arr, int aim) {
        int[] dp = new int[aim + 1];
//        初始化.因为下面要取最小值，所以这里设置为aim+1
//        切记不能设置为int最大值,不然会因超出范围出现负数导致结果错误
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;
//        外层为循环物品
        for (int i = 1; i <= arr.length; i++){
//            内层为循环背包。
//            费用为cost的物品不会影响状态f[0..cost-1]，这是显然的。因此j从arr[i - 1]开始
            for (int j = arr[i - 1]; j <= aim; j++) {
                if (j >= arr[i - 1]){
                    dp[j] = Math.min(dp[j], dp[j - arr[i - 1]] + 1);
                }
            }
        }

        return dp[aim] == aim + 1 ? -1 : dp[aim];
    }


    public static void main(String[] args) {
        int[] arr = {5, 2 ,3};
        System.out.println(minMoney(arr, 20));
    }
}
