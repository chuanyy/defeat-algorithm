package org.example.leetcode.linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * NC3 链表中环的入口结点 https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=190&&tqId=35178&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 */
public class EntryNodeOfLoopProblem {

    /**
     *  方法一:利用Set
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        if (null == pHead || pHead.next == null) {
            return null;
        }
        Set<Integer>  set = new HashSet<>();
        while (null != pHead) {
            if (set.contains(pHead.val)) {
                return pHead;
            }

            set.add(pHead.val);
            pHead = pHead.next;
        }
        return null;
    }

    /**
     *  方法一:利用快慢指针
     */

    public ListNode entryNodeOfLoop2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode slow = pHead;
        ListNode fast = pHead;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                ListNode slow2 = pHead;
                while(slow2 != slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return  null;
    }

}
