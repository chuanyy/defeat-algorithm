package org.example.leetcode.linkedList;

/**
 * 剑指 Offer 18  删除链表的节点 https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 */
public class DeleteNodeProblem {
    public ListNode deleteNode(ListNode head, int val) {
        //定义一个哑节点，哑节点指向头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        //寻找要删除的节点
        ListNode pre = dummy;
        while (null != pre.next && val != pre.next.val) {
            pre = pre.next;
        }

        //删除节点
        pre.next = null == pre.next ? null : pre.next.next;
        return dummy.next;
    }
}
