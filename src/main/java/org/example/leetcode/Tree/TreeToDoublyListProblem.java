package org.example.leetcode.Tree;

/**
 * 将一个 二叉搜索树 就地转化为一个 已排序的双向循环链表 。
 *
 * 对于双向循环列表，你可以将左右孩子指针作为双向循环链表的前驱和后继指针，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 * 特别地，我们希望可以 就地 完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中最小元素的指针。
 *
 * 参考： https://github.com/doocs/leetcode/blob/main/solution/0400-0499/0426.Convert%20Binary%20Search%20Tree%20to%20Sorted%20Doubly%20Linked%20List/README.md
 */
public class TreeToDoublyListProblem {
    private TreeNode head = new TreeNode(-1);
    private TreeNode pre = null;


    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);

        if (pre == null) {
            head.right = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;

        dfs(cur.right);
    }
}
