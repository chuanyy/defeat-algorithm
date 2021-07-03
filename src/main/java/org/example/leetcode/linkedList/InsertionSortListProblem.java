package org.example.leetcode.linkedList;

/**
 *
 */
public class InsertionSortListProblem {
    public ListNode insertionSortList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }

        //使用head节点的值作为哑节点的值（肯定不会大于head节点的值）
        ListNode dummy = new ListNode(head.val);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while (cur != null) {
            //判断当前节点是否需要插入
            if (pre.val <= cur.val) {
                pre = cur;
                cur = cur.next;
                continue;
            }

            //寻找插入位置
            ListNode index = dummy;
            while (index.next.val <= cur.val) {
                index = index.next;
            }

            //保存当前节点插入前next节点
            ListNode curFollower = cur.next;

            //插入当前节点到合适位置
            cur.next = index.next;
            index.next = cur;
            //连接断开的两端链表
            pre.next = curFollower;

            //移动当前节点到下一个
            cur = curFollower;
        }

        return dummy.next;
    }
}
