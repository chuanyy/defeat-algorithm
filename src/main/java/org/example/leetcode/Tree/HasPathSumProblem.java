package org.example.leetcode.Tree;

/**
 * 112. 路径总和 https://leetcode-cn.com/problems/path-sum/
 *
 */
public class HasPathSumProblem {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }

        return dfs(root.left, targetSum - root.val) || dfs(root.right, targetSum - root.val);
    }
}
