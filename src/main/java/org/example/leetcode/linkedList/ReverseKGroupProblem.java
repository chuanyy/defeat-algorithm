package org.example.leetcode.linkedList;

import java.util.function.DoubleUnaryOperator;

/**
 * 25. K 个一组翻转链表 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * 参考 ：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/  Roo评论
 *
 * @author lichuan
 */
public class ReverseKGroupProblem {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }

        //定义一个哑节点，其next指向head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //定义pre，end。初始化都指向dummy
        //pre指向每次要翻转的链表的头节点的上一个节点
        //end指向每次要翻转的链表的尾节点
        ListNode pre = dummy, end = dummy;

        while (null != end.next) {
            //循环k次，找到需要翻转的链表的结尾,这里每次循环要判断end是否等于空,因为如果为空，end.next会报空指针异常。
            //dummy->1->2->3->4->5 若k为2，循环2次，end指向2
            for (int i = 0; i < k && null != end; i++) {
                end = end.next;
            }

            //如果end==null，即需要翻转的链表的节点数小于k，不执行翻转。
            if (null == end) {
                break;
            }

            //保存下一组待翻转链表的头节点，方便后面链接
            ListNode next = end.next;
            //断开链表
            end.next = null;
            //拿到要翻转链表的头节点
            ListNode start = pre.next;
            //翻转链表，pre.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
            pre.next = reverse(start);
            //翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next = next;
            //将pre指向下次要翻转链表的上一个节点，即start
            pre = start;
            //翻转结束，将end指向下次要翻转链表的头节点的上一个节点。即start
            end = start;
        }

        return dummy.next;
    }


    /**
     *  链表翻转
     *  例子：   head： 1->2->3->4
     */
    public ListNode reverse(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode pre = null, cur = head, next = null;
        while (null != cur) {
            //nextNode 指向下一个节点,保存当前节点后面的链表。
            next = cur.next;
            //将当前节点next域指向前一个节点   null<-1<-2<-3<-4
            cur.next = pre;
            //pre指针向后移动。pre指向当前节点。
            pre = cur;
            //curNode指针向后移动。下一个节点变成当前节点
            cur = next;
        }

        return pre;
    }

}
