package org.example.leetcode.dp.array;

/**
 * 最长公共子串  https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=190&&tqId=36002&rp=1&ru=/activity/oj&qru=/ta/job-code-high-rd/question-ranking
 * 最长公共子序列 https://leetcode-cn.com/problems/longest-common-subsequence/
 * 最长公共子序列2 https://www.nowcoder.com/practice/6d29638c85bb4ffd80c020fe244baf11?tpId=188&&tqId=38551&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
 *
 * 注意子序列可以是不连续的，但子串一定是连续的 ：https://blog.csdn.net/u010648580/article/details/78025923
 *
 */
public class LCSProblem {
    /**
     *  最长公共子串
     *
     *  dp[i][j]=dp[i-1][j-1]+1
     *  dp[i][j]表示字符串str1中i-1个字符结尾和str2中以第j-1个字符结尾构成的最长公共子串
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        if (null == str1 || null == str2 || str1.isEmpty() || str2.isEmpty()) {
            return "";
        }
        //最长公共子串的长度
        int maxLength = 0;
        //最长公共字串最后一个字符在str1中的位置
        int maxLastIndex = 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i- 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        maxLastIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return str1.substring(maxLastIndex - maxLength + 1, maxLastIndex + 1);
    }

    /**
     *  最长公共子序列
     *  综上状态转移方程为：
     *
     * dp[i][j] = dp[i - 1][j - 1] + 1, 当 text1[i - 1] == text2[j - 1]
     * dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]), 当 text1[i - 1] != text2[j - 1
     *
     *
     *  参考 https://leetcode-cn.com/problems/longest-common-subsequence/solution/fu-xue-ming-zhu-er-wei-dong-tai-gui-hua-r5ez6/
     *
     * @param text1 string字符串 the string
     * @param text2 string字符串 the string
     * @return int 子序列长度
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (null == text1 || null == text2 || text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }
        int text1Length = text1.length();
        int text2Length = text2.length();
        int[][] dp = new int[text1Length + 1][text2Length + 1];
        for (int i = 1; i <= text1Length; i++) {
            for (int j = 1; j <= text2Length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1Length][text2Length];
    }


    /**
     *  最长公共子序列-2
     *  综上状态转移方程为：
     *
     * dp[i][j] = dp[i - 1][j - 1] + 1, 当 text1[i - 1] == text2[j - 1]
     * dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]), 当 text1[i - 1] != text2[j - 1
     *
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return int 子序列长度
     */
    public String longestCommonSubsequence2(String s1, String s2) {

        if (null == s1 || null == s2 || s1.isEmpty() || s2.isEmpty()) {
            return "-1";
        }
        int text1Length = s1.length();
        int text2Length = s2.length();
        int[][] dp = new int[text1Length + 1][text2Length + 1];
        for (int i = 1; i <= text1Length; i++) {
            for (int j = 1; j <= text2Length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int maxLength = dp[text1Length][text2Length];
        if (0 == maxLength) {
            return "-1";
        }
        int row = text1Length;
        int column = text2Length;
        //用来存储结果
        char[] result = new char[maxLength];
        // 因为要对dp倒着查看，所以lcs也倒着插入，cur表示当前插入的位置
        int cur = result.length - 1;

        while (true) {
            if (s1.charAt(row - 1) == s2.charAt(column - 1)) {
                result[cur--] = s1.charAt(row - 1);
                //cur<0即意味着lcs已经填充完毕，直接return吧
                if (cur < 0) {
                    return new String(result);
                }
                row--;
                column--;
            } else {
                // s1.charAt(row - 1) != s2.charAt(column - 1)时，就比较dp[row - 1][column] 和 dp[row][column - 1]
                // 这里用的是>而不是>=，所以dp[row - 1][column] ==dp[row][column - 1]时，走的是左边~
                if (dp[row - 1][column] > dp[row][column - 1]) {
                    //走上面
                    row--;
                } else {
                    //走左面
                    column--;
                }
            }
        }
    }
}
