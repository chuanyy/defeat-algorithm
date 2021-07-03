package org.example.leetcode.linkedList;

/**
 *  143. 重排链表 https://leetcode-cn.com/problems/reorder-list/
 *
 */
public class ReorderListProblem {
    public void reorderList(ListNode head) {
        if (null == head || null == head.next) {
            return;
        }

        //快慢指针找到链表的中点
        ListNode  slow = head, fast =head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //将链表从中点开始拆分为两个链表
        ListNode second = slow.next;
        slow.next = null;

        //反转第二部分链表
        ListNode pre = null;
        while (null != second) {
            ListNode temp = second.next;
            second.next = pre;
            pre = second;
            second = temp;
        }

        //按照题目要求合并链表
        ListNode cur = head;
        while (null != pre) {
            ListNode temp1 = cur.next;
            cur.next = pre;
            cur = temp1;
            ListNode temp2 = pre.next;
            pre.next = cur;
            pre = temp2;
        }
    }
}
