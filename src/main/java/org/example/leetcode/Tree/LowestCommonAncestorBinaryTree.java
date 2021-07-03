package org.example.leetcode.Tree;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先 https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 参考 https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
 * @author lichuan
 */
public class LowestCommonAncestorBinaryTree {

    //    *******************************方法一：迭代*************************************************************************
    //    方法一：迭代
    //    循环搜索： 当节点 root为空时跳出；
    //    （1）p,q 都在root的右子树中，则遍历至 root.right ；
    //    （2）p,q 都在root的左子树中，则遍历至 root.left ；
    //    （3）否则，说明找到了最近公共祖先 ，跳出。
    //    返回值： 最近公共祖先root 。

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (null != root) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }

    //    *******************************方法三：迭代*************************************************************************
    //    找到p、q之间的大小关系，可以简化判断条件

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode max = p.val > q.val ? p : q;
        TreeNode min = p.val < q.val ? p : q;

        while (null != root) {
            if (root.val < min.val) {
                root = root.right;
            } else if (root.val > max.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }

    //    *******************************方法三：递归*************************************************************************
    //    找到p、q之间的大小关系，可以简化判断条件

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, q, p);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }
}
