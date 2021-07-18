package org.example.leetcode.dp;

/**
 * 剑指 Offer 46. 把数字翻译成字符串 https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * @author lichuan
 */
public class TranslateNumProblem {
    /**
     *  状态定义： 设动态规划列表 dp ，dp[i] 代表以第i个元素为结尾的数字的翻译方案数量。
     *
     * 转移方程： 若 x和 xi-1组成的两位数字可以被翻译，则 dp[i]=dp[i−1]+dp[i−2] ；dp[i]=dp[i−1] 。
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        //初始状态： dp[0] = dp[1] = 1 ，即 “无数字” 和 “第 1 位数字” 的翻译方法数量均为 1 ；
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= str.length(); i++) {
            //取出第i-1、i两位字符。对于字符串来说i是从0开始的
            String temp  = str.substring(i - 2, i);
            dp[i] = "10".compareTo(temp) <= 0 && "25".compareTo(temp) >= 0 ? dp[i - 2] + dp[i - 1] : dp[i - 1];
        }

        return dp[str.length()];
    }

    /**
     * 空间优化 dp[i]只和dp[i-1]、dp[i-2]有关
     *
     */
    public int translateNumOp(int num) {
        String str = String.valueOf(num);
        int dp1 = 1, dp2 = 1;
        for (int i = 2; i <= str.length(); i++) {
            //取出第i-1、i两位字符。对于字符串来说i是从0开始的
            String temp  = str.substring(i - 2, i);
            int c = "10".compareTo(temp) <= 0 && "25".compareTo(temp) >= 0 ? dp1 + dp2 : dp2;
            dp1 = dp2;
            dp2 = c;
        }

        return dp2;
    }


    /**
     * 牛客网 变形题 https://www.nowcoder.com/practice/046a55e6cd274cffb88fc32dba695668?tpId=190&&tqId=36079&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     *
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve (String nums) {
        if(null == nums){
            return 0;
        }
        //dp[i]表示以第i个元素为结尾的数字的翻译方案数量
        int[] dp = new int[nums.length() + 1];
        //初始状态；
        dp[0] = 1;
        //第一个字符为0是不能被翻译的
        dp[1] = nums.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= nums.length(); i++) {
            //单个字符为0是不能被翻译的
            dp[i] = nums.charAt(i - 1) == '0' ? 0 : dp[i - 1];
            //取出第i-1、i两位字符。对于字符串来说i是从0开始的
            String temp  = nums.substring(i - 2, i);
            if ("10".compareTo(temp) <= 0 && "26".compareTo(temp) >= 0) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }

        return dp[nums.length()];
    }

}
