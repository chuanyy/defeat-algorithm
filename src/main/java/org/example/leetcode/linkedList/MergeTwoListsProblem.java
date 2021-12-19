package org.example.leetcode.linkedList;

import java.util.ArrayList;

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

    /**
     * 3. 合并K个升序链表 https://leetcode-cn.com/problems/merge-k-sorted-lists/
     * NC51 合并k个已排序的链表  https://www.nowcoder.com/practice/65cfde9e5b9b4cf2b6bafa5f3ef33fa6?tpId=190&&tqId=35193&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode listNode : lists) {
            res = mergeTwoLists(res, listNode);
        }
        return res;
    }
}
