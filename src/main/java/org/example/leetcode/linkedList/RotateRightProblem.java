package org.example.leetcode.linkedList;

/**
 *
 * 将链表右半部分的 k 的节点拼接到 head 即可。
 * 注：k 对链表长度 n 取余，即 k %= n。
 */
public class RotateRightProblem {
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head ||  null == head.next) {
            return head;
        }

        //求链表的长度
        int n = 0;
        ListNode cur = head;
        while (null != cur) {
            ++n;
            cur = cur.next;
        }

        k %= n;
        if (0 == k) {
            return head;
        }

        //使用快慢指针定位到右半部分k节点
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        //此处使用fast.next来判断，跳出循环时slow为k的前一个节点,fast为最后一个节点
        while (null != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        //k节点，也是新链表的头节点
        ListNode nodeK = slow.next;
        slow.next = null;
        fast.next = head;

        return nodeK;
    }
}
