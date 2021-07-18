package org.example.leetcode.math;

/**
 * NC112 进制转换 https://www.nowcoder.com/practice/2cc32b88fff94d7e8fd458b8c7b25ec1?tpId=190&&tqId=35410&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class BaseConversionProblem {
    /**
     * 进制转换
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve (int M, int N) {
        final String numbers = "0123456789ABCDEF";
        if (0 == M) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        if (0 > M) {
            negative = true;
            M = -M;
        }
        while (0 != M) {
            sb.append(numbers.charAt(M % N));
            M = M / 10;
        }
        if (negative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}
