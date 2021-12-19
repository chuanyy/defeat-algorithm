package org.example.leetcode.math;

/**
 * NC56 回文数字
 * https://www.nowcoder.com/practice/35b8166c135448c5a5ba2cff8d430c32?tpId=190&&tqId=35359&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class IsPalindromeProblem {
    public boolean isPalindrome (int x) {
        if (x < 0) {
            return false;
        }
        long temp = x;
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res == temp;
    }
}
