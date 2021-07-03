package org.example.leetcode.linkedList;

/**
 * 92. 反转链表 II https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class ReverseBetweenProblem {

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
     * 方法2：迭代
     */
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (null == head || null == head.next || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, cur = head;
        //找到索引为m的节点
        for (int i = 0; i < m - 1; i++) {
            pre = cur;
            cur = cur.next;
        }

        //此处使用新的引用指向上面的pre和cur，因为后面会用到pre和cur
        ListNode p = pre, q = cur;
        //此处使用n - m + 1是因为需要n-m+1次变换指针方向
        for (int i = 0; i < n - m + 1; i++) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }

        p.next = pre;
        cur.next = q;

        return dummy.next;
    }

    /**
     * 反转链表的前N个节点
     */
    ListNode successor = null; // 后继节点
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
}

