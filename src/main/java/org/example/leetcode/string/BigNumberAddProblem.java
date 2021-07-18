package org.example.leetcode.string;

import java.math.BigInteger;

/**
 * NC1 大数加法 https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=190&&tqId=36034&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 */
public class BigNumberAddProblem {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        BigInteger bigInteger1 = new BigInteger(s);
        BigInteger bigInteger2 = new BigInteger(t);

        return bigInteger1.add(bigInteger2).toString();
    }


    /**
     * 面试解法
     */
    public String solve2 (String s, String t) {
        if ((null == s || null == t) || (s.isEmpty() && t.isEmpty())) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        int carry = 0, i = s.length() - 1, j = t.length() - 1;
        //循环条件记得加上 0 != carry，因为最后一次相加可能会产生进位
        while (0 <= i || 0 <= j || 0 != carry) {
            int x = i < 0 ? 0 : s.charAt(i--) - '0';
            int y = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = x + y + carry;
            result.insert(0, sum % 10);
            carry = sum / 10;
        }

        return result.toString();
    }
}
