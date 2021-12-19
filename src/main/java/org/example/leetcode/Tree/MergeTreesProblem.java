package org.example.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 617. 合并二叉树 https://leetcode-cn.com/problems/merge-two-binary-trees/
 * NC117 合并二叉树 https://www.nowcoder.com/practice/7298353c24cc42e3bd5f0e0bd3d1d759?tpId=190&&tqId=36108&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * @author lichuan
 */
public class MergeTreesProblem {
    /**
     * 方法一 递归
     *
     * 都合并到第一颗树上
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (null == root1 || null == root2) {
            return null == root1 ? root2 : root1;
        }

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }

    /**
     * 方法二 迭代
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if(null == t1 || null == t2) {
            return null == t1 ? t2 : t1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(t1);
        queue.offer(t2);

        while (!queue.isEmpty()) {
            TreeNode r1 = queue.poll();
            TreeNode r2 = queue.poll();
            r1.val += r2.val;

            if (null != r1.left && null != r2.left) {
                queue.offer(r1.left);
                queue.offer(r2.left);
            } else if (null == r1.left) {
                r1.left = r2.left;
            }

            if (null != r1.right && null != r2.right) {
                queue.offer(r1.right);
                queue.offer(r2.right);
            } else if (null == r1.right){
                r1.right = r2.right;
            }
        }

        return t1;
    }
}
