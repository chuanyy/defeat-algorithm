package org.example.leetcode.math;

import com.sun.source.tree.BreakTree;

/**
 * NC57 反转数字
 *
 * @author lichuan
 */
public class ReverseNumberProblem {
    public int reverse (int x) {
       long res = 0;
       while (x != 0) {
           res = res * 10 + x % 10;
           x /= 10;
       }
       return (int) res == res ? (int)res : 0;
    }
}
