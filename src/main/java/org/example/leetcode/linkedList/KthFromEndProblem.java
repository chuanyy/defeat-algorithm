package org.example.leetcode.linkedList;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点 https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * 定义 fast、slow 指针指向 head。
 *
 * fast先向前走 k 步，接着 fast、slow 同时向前走，当 fast 指向 null 时，slow 指向的节点即为链表的倒数第 k 个节点。
 */
public class KthFromEndProblem {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (null == head) {
            return null;
        }

        ListNode fast = head, slow = head;
        while (k-- > 0 &&  null != fast) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
