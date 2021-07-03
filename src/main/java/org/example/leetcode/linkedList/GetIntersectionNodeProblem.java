package org.example.leetcode.linkedList;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点 https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 *
 * 参考 https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
 *
 * @author lichuan
 */
public class GetIntersectionNodeProblem {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //若两个链表至少有一个为null，则一定不会相交，直接返回null
        if (null == headA || null == headB) {
            return null;
        }
        //题解：设链表A的长度为a+c，链表B的长度为b+c，a为链表A不公共部分，b为链表B不公共部分，c为链表A、B的公共部分
        //将两个链表连起来，A->B和B->A，长度：a+c+b=b+c+a，若链表AB相交，则a+c+b与b+c+a就会抵消，它们就会在c处相遇；若不相交，则c为null，则a+b=b+a，它们各自移动到尾部循环结束，即返回null
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            //当pA或pB为空时，它们开始指向另一链表的头部，每次判断pA或pB是否为空进行赋值的好处是当链表AB没有公共部分时pA和pB同时为空，这样避免了死循环
            pA = null == pA ? headB : pA.next;
            pB = null == pB ? headA : pB.next;
        }

        return pA;
    }
}
