package org.example.leetcode.string;

import java.util.function.Predicate;

/**
 * 旋转字符串问题
 *
 * @author lichuan
 */
public class RotateStringProblem {

    //NC114 旋转字符串 https://www.nowcoder.com/practice/80b6bb8797644c83bc50ac761b72981c?tpId=190&&tqId=36926&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking

    /**
     *  方法一
     * @param A string字符串
     * @param B string字符串
     * @return bool布尔型
     */
    public boolean solve (String A, String B) {
        //特殊情况处理
        if (null == A || null == B || A.length() != B.length() || A.length() < 2 || B.length() < 2) {
            return false;
        }
        //1、假如 A="abcd" 则 A+A = "abcdabcd"
        //2、如果B 满足 题目的条件，则B 一定属于 A+A 里面的一个子串
        return (A + A).contains(B);
    }

    /**
     *  方法二 暴力法
     * @param A string字符串
     * @param B string字符串
     * @return bool布尔型
     */
    public boolean solve2 (String A, String B) {
        //特殊情况处理
        if (null == A || null == B || A.length() != B.length() || A.length() < 2 || B.length() < 2) {
            return false;
        }
        int i = 1;
        while (i < A.length()) {
            String head = A.substring(0, i);
            String tail = A.substring(i);
            if ((tail + head).contains(B)) {
                return true;
            }
            i++;
        }

        return false;
    }


}
