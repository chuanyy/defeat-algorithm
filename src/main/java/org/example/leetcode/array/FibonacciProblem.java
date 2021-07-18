package org.example.leetcode.array;

/**
 * 剑指 Offer 10- I. 斐波那契数列 https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * @author lichuan
 */
public class FibonacciProblem {

    public int fibonacci(int n) {
        int a = 0, b = 1;
        for(int i = 0; i < n; i++) {
            //这里计算的是f(i+1)
            int sum = a + b;
            a = b;
            b = sum;
        }
        //这里应返回f(i),即a
        return a;
    }
}
