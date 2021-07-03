package org.example.leetcode.datastructure;

import java.util.Stack;

/**
 *  剑指 Offer 30. 包含min函数的栈 https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 *
 *  参考：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/solution/mian-shi-ti-30-bao-han-minhan-shu-de-zhan-fu-zhu-z/
 *
 * @author lichuan
 */
public class MinStack {
    Stack<Integer> A, B;
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.push(x);
        //注意此处为大于等于，因为有重复的元素
        if (B.isEmpty() || B.peek() >= x) {
            B.push(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
