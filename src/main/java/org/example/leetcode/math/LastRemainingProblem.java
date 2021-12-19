package org.example.leetcode.math;

import org.example.leetcode.linkedList.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 环形链表的约瑟夫环
 * https://www.nowcoder.com/practice/41c399fdb6004b31a6cbb047c641ed8a?tpId=190&&tqId=36013&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 */
public class LastRemainingProblem {

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

    //**********************************方法三：链表模拟******************************************************************

    public int ysf(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        ListNode head = new ListNode(1);
        ListNode tail = head;
        for (int i = 2; i <= n; i++) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }

        //链接成环
        tail.next = head;
        ListNode index = head;
        ListNode pre = tail;
        int k = 0;
        while (null != index.next && index.next != index) {
          k++;
          ListNode next = index.next;
          if (m == k) {
              pre.next = pre.next.next;
              k =0;
          }
          pre = index;
          index = next;
        }
        return index.val;
    }

}
