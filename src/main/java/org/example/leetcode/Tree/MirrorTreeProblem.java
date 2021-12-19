package org.example.leetcode.Tree;

import java.util.LinkedList;

/**
 * 剑指 Offer 27. 二叉树的镜像 https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * NC72 二叉树的镜像 https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=190&&tqId=35200&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class MirrorTreeProblem {
    /**
     * 方法一 递归
     */
    public TreeNode mirrorTree (TreeNode root) {
        if (null == root) {
            return null;
        }

        //先翻转左子树和右子树
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        //然后交换根节点的左右子树
        root.left = right;
        root.right = left;

        return root;
    }

    /**
     * 方法二 迭代
     *
     */
    public TreeNode mirrorTree2(TreeNode root) {
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
