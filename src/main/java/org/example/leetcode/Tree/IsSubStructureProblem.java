package org.example.leetcode.Tree;

import javax.print.DocFlavor;

/**
 * 剑指 Offer 26. 树的子结构 https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 *
 *  参考：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/solution/mian-shi-ti-26-shu-de-zi-jie-gou-xian-xu-bian-li-p/
 */
public class IsSubStructureProblem {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == A || null == B) {
            return false;
        }
        //中序遍历找子结构
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode nodeA, TreeNode nodeB) {
        //B树遍历完了，说明B是A的子结构
        if (null == nodeB) {
            return true;
        }

        if (null == nodeA || nodeA.val != nodeB.val) {
            return false;
        }

        return recur(nodeA.left, nodeB.left) && recur(nodeA.right, nodeB.right);
    }
}
