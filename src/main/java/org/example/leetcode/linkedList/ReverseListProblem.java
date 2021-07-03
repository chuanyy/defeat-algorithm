package org.example.leetcode.linkedList;

/**
 *
 *  剑指 Offer 24. 反转链表 https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 *
 *
 */
public class ReverseListProblem {

    /**
     * 方法1 ：迭代
     */
    public ListNode reverseList(ListNode head) {
        if(null == head || null == head.next) {
            return head;
        }
        ListNode pre = null, p = head;
        while(p != null) {
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }

        return pre;
    }

    /**
     * 方法2 ：递归
     */
    public ListNode reverseList2(ListNode head) {
        if(null == head || null == head.next) {
            return head;
        }
        //从后往前反转
        ListNode res = reverseList2(head.next);
        //下一个节点的next指向当前节点
        head.next.next = head;
        //当前节点的next置为null
        head.next = null;
        return res;
    }
}
