package org.example.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径 https://leetcode-cn.com/problems/binary-tree-paths/
 *
 * 
 */
public class BinaryTreePathsProblem {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode root, String path, List<String> paths) {
        if (null == root) {
            return;
        }
        //遍历到叶子节点，说明找到一条路径
        if (null == root.left && null == root.right) {
            paths.add(path + root.val);
        }
        //递归遍历左子树、右子树
        dfs(root.left, path + root.val+"->", paths);
        dfs(root.right, path + root.val+"->", paths);
    }
}
