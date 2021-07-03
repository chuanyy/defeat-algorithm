package org.example.leetcode.linkedList;

/**
 *  剑指 Offer 25. 合并两个排序的链表 https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 *
 * @author lichuan
 */
public class MergeTwoListsProblem {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;

        while (null != l1 && null != l2) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        cur.next = null == l1 ? l2 : l1;

        return dummy.next;
    }
}
