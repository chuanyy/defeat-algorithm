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


    /**
     * NC98 判断t1树中是否有与t2树拓扑结构完全相同的子树 使用一下recur函数
     * https://www.nowcoder.com/practice/4eaccec5ee8f4fe8a4309463b807a542?tpId=190&&tqId=35222&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     */
    private boolean recur2(TreeNode nodeA, TreeNode nodeB) {
        //B树遍历完了，说明B是A的子结构
        if (null == nodeA && null == nodeB) {
            return true;
        }

        if (null == nodeA || null == nodeB || nodeA.val != nodeB.val) {
            return false;
        }

        return recur(nodeA.left, nodeB.left) && recur(nodeA.right, nodeB.right);
    }
}
