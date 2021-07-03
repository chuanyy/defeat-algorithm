package org.example.leetcode.linkedList;

/**
 * 24. 两两交换链表中的节点 https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 */
public class SwapPairsProblem {

    /**
     * 方法一：递归
     * 用 head 表示原始链表的头节点，新的链表的第二个节点，用 newHead 表示新的链表的头节点，原始链表的第二个节点，
     * 则原始链表中的其余节点的头节点是 newHead.next。令 head.next = swapPairs(newHead.next)，
     * 表示将其余节点进行两两交换，交换后的新的头节点为 head 的下一个节点。然后令 newHead.next = head，
     * 即完成了所有节点的交换。最后返回新的链表的头节点 newHead。
     */
    public ListNode swapPairs1(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode newHead = head.next;
        head.next = swapPairs1(newHead.next);
        newHead.next = head;

        return newHead;
    }

    /**
     * 方法二：迭代
     *
     * 创建哑结点 dummyHead，令 dummyHead.next = head。令 temp 表示当前到达的节点，初始时 temp = dummyHead。每次需要交换 temp 后面的两个节点。
     * 如果 temp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。否则，获得 temp 后面的两个节点 node1 和 node2，
     * 通过更新节点的指针关系实现两两交换节点。
     *
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;

        while (null != temp.next && null != temp.next.next) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            temp = node1;
        }

        return dummy.next;
    }
}
