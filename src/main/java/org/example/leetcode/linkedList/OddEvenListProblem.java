package org.example.leetcode.linkedList;

/**
 * 328. 奇偶链表 https://leetcode-cn.com/problems/odd-even-linked-list/
 * NC133 链表的奇偶重排 https://www.nowcoder.com/practice/02bf49ea45cd486daa031614f9bd6fc3?tpId=190&&tqId=36037&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class OddEvenListProblem {
    public ListNode oddEvenList(ListNode head) {
        if (null == head) {
            return null;
        }

        //偶节点链表头部节点
        ListNode evenHead = head.next;
        //当前的奇数节点、偶数节点
        ListNode odd = head, even = evenHead;
        //由于奇数链被要求放在结果链的前半部分, 所以奇数链的最后一个元素不能为空
        //但是技术链表需要右even节点更新，即只要even ！= null并且even.next!=null,
        while (null != even && null != even.next) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
