package org.example.leetcode.dp.string;

/**
 * 72. 编辑距离 https://leetcode-cn.com/problems/edit-distance/
 *
 * 参考：https://leetcode-cn.com/problems/edit-distance/solution/bian-ji-ju-chi-by-leetcode-solution/
 *
 * @author lichuan
 */
public class MinDistanceProblem {

    public int minDistance(String word1, String word2) {
        if (null == word1 || null == word2) {
            return 0;
        }

        int length1 = word1.length();
        int length2 = word2.length();

        // 有一个字符串为空串
        if (length1 * length2 == 0) {
            return length1 + length2;
        }

        //dp[i][j]表示我word1的前i个字母和word2的前j个字母之间的最小编辑距离
        int[][] dp = new int[length1 + 1][length2 + 1];

        //word1的前i个字母和word2的前0个字母之间的最小编辑距离一定为i
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }
        //word1的前0个字母和word2的前j个字母之间的最小编辑距离一定为j
        for (int j = 0; j <= length2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= length1; i++){
            for (int j = 1; j <= length2; j++) {
                //当i字符等于j字符时：dp[i][j] = dp[i-1][j-1]，不需要额外操作
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j- 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[length1][length2];
    }


    /**
     * 牛客网： https://www.nowcoder.com/practice/05fed41805ae4394ab6607d0d745c8e4?tpId=190&&tqId=35213&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     *
     * min edit cost
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic int整型 insert cost
     * @param dc int整型 delete cost
     * @param rc int整型 replace cost
     * @return int整型
     */
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        if (null == str1 || null == str2) {
            return 0;
        }

        int length1 = str1.length();
        int length2 = str2.length();

        // 有一个字符串为空串
        if (length1 * length2 == 0) {
            return length1 + length2;
        }

        //dp[i][j]表示我word1的前i个字母和word2的前j个字母之间的最小编辑距离
        int[][] dp = new int[length1 + 1][length2 + 1];

        //word1的前i个字母和word2的前0个字母之间的最小编辑距离一定为i
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i * dc;
        }
        //word1的前0个字母和word2的前j个字母之间的最小编辑距离一定为j
        for (int j = 0; j <= length2; j++) {
            dp[0][j] = j * ic;
        }

        for (int i = 1; i <= length1; i++){
            for (int j = 1; j <= length2; j++) {
                //当i字符等于j字符时：dp[i][j] = dp[i-1][j-1]，不需要额外操作
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j- 1] + ic;
                    int delete = dp[i - 1][j] + dc;
                    int replace = dp[i - 1][j - 1] + rc;
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[length1][length2];
    }
}
