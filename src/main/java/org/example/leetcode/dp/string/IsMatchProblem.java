package org.example.leetcode.dp.string;

/**
 * NC44 通配符匹配： https://www.nowcoder.com/practice/e96f1a44d4e44d9ab6289ee080099322?tpId=190&&tqId=36056&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 *
 * @author lichuan
 */
public class IsMatchProblem {
    public boolean isMatch(String s, String p) {
        if(null == s || null == p ) {
            return false;
        }

        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();

        int strLength = str.length;
        int ptrLength = ptr.length;

        //dp[i][j]表示str的前i个字符和ptr的前j个字符的匹配结果
        //默认值都为false
        //1、包含了对dp[i][0]的赋值（当i>0时，主串非空，模式串为空，不匹配）
        boolean[][] dp = new boolean[strLength + 1][ptrLength + 1];
        //2、两个空串匹配
        dp[0][0] = true;
        //3、 dp[0][j]如果主串为空且p[..]中只含有*，匹配；如果主串为空且p[..]中不仅含有*，不匹配
        for (int j = 1; j <= ptrLength; j++) {
            if (ptr[j - 1] == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= strLength; i++) {
            for (int j = 1; j <= ptrLength; j++) {
                //4、如果当前字符匹配，那么是否匹配取决于各自子串
                if (str[i - 1] == ptr[j -1] || ptr[j - 1] == '?') {
                    dp[i][j] = dp[i- 1][j- 1];
                }
                //5、如果模式串当前字符为*，那么是否匹配取决于主串中是否存在子串能与p[0..j-1]匹配上
                else if (ptr[j - 1] == '*'){
                    //匹配0个或者多个
                    //如果不为空字符串，可以代表任意一段字符串，也就是说只要任意dp[k][j-1]成立（k属于 [0,i-1]）,
                    // dp[i][j]就成立 。那么怎么知道dp[k][j-1]是否成立呢？如果再次循环k的话时间复杂度过高，
                    // 这里可以考虑两种方法：
                    // 1）使用一个flag记录遍历j-1时是否会有成立的情况
                    // 2）直接考虑 dp[i][j] = dp[i-1][j],因为计算dp[i-1][j]时又会考虑考虑dp[i-2][j]的成立，
                    //   所以能找到一个dp[k][j]成立的话，就会使之后的所有dp[i][j]成立。
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[strLength][ptrLength];
    }
}
