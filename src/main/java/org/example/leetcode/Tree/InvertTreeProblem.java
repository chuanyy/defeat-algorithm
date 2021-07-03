package org.example.leetcode.Tree;

import java.util.LinkedList;

/**
 * 226. 翻转二叉树  https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * 参考：1递归
 *  2非递归
 *
 * @author lichuan
 */
public class InvertTreeProblem {
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }

        //先翻转左子树和右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        //然后交换根节点的左右子树
        root.left = right;
        root.right = left;

        return root;
    }

    //非递归方式
    public TreeNode invertTree2(TreeNode root) {
        if (null == root) {
            return null;
        }

        //将二叉树的节点逐层放入队列中，再迭代反转队列中每个节点的左右子树
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (null != node.left) {
                queue.offer(node.left);
            }

            if (null != node.right) {
                queue.offer(node.right);
            }
        }

        return root;

    }
}
