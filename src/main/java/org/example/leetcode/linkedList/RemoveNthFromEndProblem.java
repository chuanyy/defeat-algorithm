package org.example.leetcode.linkedList;

/**
 * 19. 删除链表的倒数第 N 个结点 https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * 参考：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/hua-jie-suan-fa-19-shan-chu-lian-biao-de-dao-shu-d/#comment
 */
public class RemoveNthFromEndProblem {
    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        //快指针先向前走n步，则快慢指针之间相差了n个节点（包括快指针指向的节点）
        while (0 != n) {
            fast = fast.next;
            n--;
        }

        //循环结束后，slow指针指向要删除节点的前一个节点
        while (null != fast.next) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
