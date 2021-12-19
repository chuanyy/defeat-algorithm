package org.example.leetcode.linkedList;

import java.awt.*;
import java.util.List;

/**
 *
 * @author lichuan
 */
public class DeleteDuplicatesProblem {
    /**
     * 83. 删除排序链表中的重复元素
     *  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
     *  NC25 删除有序链表中重复的元素-I
     *  https://www.nowcoder.com/practice/c087914fae584da886a0091e877f2c79?tpId=190&&tqId=35186&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     */
    public ListNode deleteDuplicates (ListNode head) {
        if (null == head) {
            return null;
        }

        ListNode cur = head;
        while (null != cur.next) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 82. 删除排序链表中的重复元素 II
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
     * NC24 删除有序链表中重复的元素-II
     * https://www.nowcoder.com/practice/71cef9f8b5564579bf7ed93fbe0b2024?tpId=190&&tqId=35342&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     *
     * 参考：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/shan-chu-pai-xu-lian-biao-zhong-de-zhong-oayn/
     *
     * 由于链表的头节点可能会被删除，因此我们需要额外使用一个哑节点（dummy node）指向链表的头节点。
     *
     * 们从指针 cur 指向链表的哑节点，随后开始对链表进行遍历。
     * 如果当前 cur.next 与 cur.next.next 对应的元素相同，
     * 那么我们就需要将 cur.next 以及所有后面拥有相同元素值的链表节点全部删除。
     * 我们记下这个元素值 xx，随后不断将 cur.next 从链表中移除，
     * 直到 cur.next 为空节点或者其元素值不等于 xx 为止。
     * 此时，我们将链表中所有元素值为 xx 的节点全部删除。
     *
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(null == head) {
            return null;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while(null != cur.next && null != cur.next.next) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
