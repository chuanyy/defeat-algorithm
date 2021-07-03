package org.example.leetcode.Tree;

/**
 * 面试题 17.12. 将二叉搜索树转换为单链表
 * BiNode https://leetcode-cn.com/problems/binode-lcci/
 * 参考：https://leetcode-cn.com/problems/binode-lcci/solution/binode100jian-dan-yi-dong-by-zui-weng-jiu-xian/
 */
public class ConvertBiNodeProblem {
    private final TreeNode head = new TreeNode(-1);
    private TreeNode prev = null;

    public TreeNode convertBiNode(TreeNode root) {
        helper(root);
        return head.right;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        //二叉搜索树的中序遍历，可以得到一个升序序列
        helper(root.left);
        if (prev == null) { //第一个节点
            head.right = root;
        }else { //第一个节点之后的节点
            prev.right = root;
        }
        prev = root;
        // 当前节点的左指针设为null
        root.left = null;
        helper(root.right);
    }
}
