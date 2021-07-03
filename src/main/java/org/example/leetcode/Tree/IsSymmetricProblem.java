package org.example.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 101. 对称二叉树  https://leetcode-cn.com/problems/symmetric-tree/
 *
 */
public class IsSymmetricProblem {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    /**
     * 方法1：递归实现
     */
    private boolean check(TreeNode l, TreeNode r) {
        if (null == l && null == r) {
            return true;
        }

        if (null == l || null == r || l.val != r.val) {
            return false;
        }

        return check(l.left, r.right) && check(l.right, r.left);
    }

    /**
     * 方法2：迭代实现
     */
    private boolean check2(TreeNode l, TreeNode r) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(l);
        queue.offer(r);

        while (!queue.isEmpty()) {
            l = queue.poll();
            r = queue.poll();

            if (null == l && null == r)
                continue;

            if ((null == l || null == r) || (l.val != r.val))
                return false;

            queue.offer(l.left);
            queue.offer(r.right);

            queue.offer(l.right);
            queue.offer(r.left);
        }
        return true;
    }
}
