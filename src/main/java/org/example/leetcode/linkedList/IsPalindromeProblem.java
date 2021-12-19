package org.example.leetcode.linkedList;

/**
 * 234. 回文链表 https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 *
 */
public class IsPalindromeProblem {
    public boolean isPalindrome(ListNode head) {
        if (null == head || head.next == null) {
            return true;
        }
        //使用快慢指针找到链表中间位置，并翻转前半段链表
        ListNode slow = head, fast = head;
        ListNode cur = head, pre = null;
        while (null != fast && null != fast.next) {
            cur = slow;
            slow = slow.next;
            fast = fast.next.next;

            cur.next = pre;
            pre = cur;
        }

        //如果节点个数为奇数，需要将慢指针往后移动一个节点，得到后半段链表
        if (fast != null) {
            slow = slow.next;
        }

        while(pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }

            pre = pre.next;
            slow = slow.next;
        }

        return true;
    }
}
