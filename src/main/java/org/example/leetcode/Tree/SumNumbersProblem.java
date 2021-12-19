package org.example.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 129. 求根节点到叶节点数字之和 https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * NC5 二叉树根节点到叶子节点的所有路径和 https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=190&&tqId=35580&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 *
 *
 * @author lichuan
 */
public class SumNumbersProblem {
    /**
     * 方法一，递归
     *
     * 线序遍历，从根节点往下走，那么节点的值九四父节点的值*10+当前节点的值。
     * 默认根节点的父节点的值尾0，如果道道叶子节点，就用一个全局的变量把叶子节点的值加起来
     */
    public int sumNumbers (TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int presum) {
        if (null == root) {
            return 0;
        }

        int sum = presum * 10 + root.val;
        if (null == root.left && null == root.right) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }


    /**
     * 方法二、广度优先遍历
     */
    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}
