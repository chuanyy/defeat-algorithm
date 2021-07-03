package org.example.leetcode.math;

import org.example.leetcode.linkedList.ListNode;

import java.util.LinkedList;
import java.util.List;

public class lastRemainingProblerm {

    //**********************************方法一：数学+迭代******************************************************************

    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

    //**********************************方法二：数学+递归******************************************************************

    public int lastRemaining2(int n, int m) {
        if(n==1) {
            return 0;
        }
        return (lastRemaining2(n-1,m)+m)%n;
    }


    //**********************************方法三：数学******************************************************************
    //会超时

    public int lastRemaining3(int n, int m) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }
}
