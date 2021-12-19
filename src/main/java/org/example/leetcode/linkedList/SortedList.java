package org.example.leetcode.linkedList;

/**
 * 148. 排序链表  https://leetcode-cn.com/problems/sort-list/
 *
 * 参考：https://leetcode-cn.com/problems/sort-list/solution/pai-xu-lian-biao-by-leetcode-solution/
 *
 * @author lichuan
 */
public class SortedList {
    /**
     * 方法一 迭代
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        //求出链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        ListNode dummyNode = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength *= 2) {
            ListNode prev = dummyNode, cur = dummyNode.next;
            while (cur != null) {
                //子链1
                ListNode head1 = cur;
                for (int i = 1; i < subLength && cur.next != null; i++) {
                    cur = cur.next;
                }

                //子链2
                ListNode head2 = cur.next;
                //与子链1断开，这步必须要有
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }

                //下一轮开始节点，这段代码放在这里不放在最后，是因为merge后节点的顺序会改变
                ListNode next = null;
                if (cur != null) {
                    next = cur.next;
                    //将子链2与后续断开
                    cur.next = null;
                }
                cur = next;

                //合并两个有序链表,prev的作用是将每轮subLength拆分的子链表连接起来
                prev.next = merge(head1, head2);
                //移动prev指针到合适位置
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }
        return dummyNode.next;
    }

//    递归
    public ListNode sortList2(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        //步骤2
        //当只有一个节点时，需要将该节点与后续节点断开链接，进行孤立
        //即 head.next = null
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        //找到链表的中间节点，使用快慢指针思想
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }

        ListNode mid = slow;
        //不包含右边界节点，步骤2中去除
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return merge(list1, list2);
    }

    /**
     * 合并两个排序后的链表
     * @param head1 链表1
     * @param head2 链表2
     * @return 合并后的链表
     */
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode(0);
        ListNode temp = dummyNode, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }

        return dummyNode.next;
    }
}
