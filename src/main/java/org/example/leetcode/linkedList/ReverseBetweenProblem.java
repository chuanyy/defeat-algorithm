package org.example.leetcode.linkedList;

/**
 * 92. 反转链表 II https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseBetweenProblem {

    /**
     * 反转链表的前N个节点
     */
    // 后继节点
    ListNode successor = null;
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;

        return newHead;
    }

    /**
     * 方法一使用递归
     *
     * 参考：https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (null == head || null == head.next || m == n) {
            return head;
        }
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 方法2：一次遍历「穿针引线」反转链表（头插法）
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (null == head || null == head.next || left == right) {
            return head;
        }// 设置 dummyNode 是这一类问题的一般做法

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        //pre用来保存left的前驱节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next, next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummy.next;
    }

    /**
     * 方法3：穿针阴线
     * 思路：
     *      1、先将待反转的区域反转
     *      2、把pre的next指针指向翻转以后的链表头节点，把反转以后的链表的尾节点指向succ
     */
    public ListNode reverseBetween3(ListNode head, int left, int right) {
        //因为头节点有可能发生变化，使用哑节点可以避免复杂的分类问题
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //pre用来保存left的前驱节点
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        //找到right节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        //截取链表，并切断
        ListNode leftNode = pre.next;
        ListNode successorNode = rightNode.next;
        pre.next = null;
        rightNode.next = null;

        //反转链表
        reverseLinkedList(leftNode);

        //接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = successorNode;
        return dummy.next;
    }


    /**
     * 反转链表
     */
    private void reverseLinkedList(ListNode head) {
        ListNode pre = null, cur = head;
        while (null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

    }

}



