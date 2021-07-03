package org.example.leetcode.linkedList;

import java.util.Stack;

/**
 * 剑指 Offer 06 从尾到头打印链表 https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 */
public class ReversePrintProblem {

    public int[] reversePrint(ListNode head) {
        if (null == head) {
            return new int[0];
        }

        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop().val;
        }

        return ans;
    }
}
