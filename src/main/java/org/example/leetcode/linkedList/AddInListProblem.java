package org.example.leetcode.linkedList;

/**
 * NC40 两个链表生成相加链表 https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=190&&tqId=35219&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class AddInListProblem {
    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode dummy = new ListNode(0), cur = dummy;
        //进位
        int carry = 0;
        while (null != head1 || null != head2) {
            int x = (null != head1) ? head1.val : 0;
            int y = (null != head2) ? head2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (null != head1) {
                head1 = head1.next;
            }
            if (null != head2) {
                head2 = head2.next;
            }
        }

        if (0 < carry) {
            cur.next = new ListNode(carry);
        }

        return reverse(dummy.next);
    }


    /**
     * 翻转链表
     */
    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
