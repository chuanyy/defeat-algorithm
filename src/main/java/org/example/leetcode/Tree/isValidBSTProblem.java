package org.example.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * NC60 判断一棵二叉树是否为搜索二叉树和完全二叉树
 *
 * @author lichuan
 */
public class isValidBSTProblem {

    /**
     * 98. 验证二叉搜索树  https://leetcode-cn.com/problems/validate-binary-search-tree/
     * 参考：https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
     */
    public boolean isValidBST(TreeNode root) {
            return isValidBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (null == node) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        return isValidBST(node.left, lower, node.val)
                && isValidBST(node.right, node.val, upper);
    }

    /**
     * 958. 二叉树的完全性检验 https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
     * 参考：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/solution/er-cha-shu-de-wan-quan-xing-jian-yan-by-leetcode/
     *
     * 对于根节点，我们定义其编号为 1。然后，对于每个节点 v，我们将其左节点编号为 2 * v，
     * 将其右节点编号为 2 * v + 1。
     * 我们可以发现，树中所有节点的编号按照广度优先搜索顺序正好是升序。
     * （也可以使用深度优先搜索，之后对序列排序）。
     * 然后，我们检测编号序列是否为无间隔的 1, 2, 3, …，事实上，我们只需要检查最后一个编号是否正确，
     * 因为最后一个编号的值最大。
     *
     */
    public boolean isCompleteTree(TreeNode root) {
        if (null == root) {
            return true;
        }
        List<ANode> list = new ArrayList<>();
        list.add(new ANode(root, 1));
        int i = 0;
        while (i < list.size()) {
            ANode cur =list.get(i++);
            if (null != cur.node) {
                list.add(new ANode(cur.node.left, cur.code * 2));
                list.add(new ANode(cur.node.right, cur.code * 2 + 1));
            }
        }
        return list.get(i - 1).code == list.size();
    }
}

class ANode {
    TreeNode node;
    int code;

    public ANode(TreeNode node, int code) {
        this.node = node;
        this.code = code;
    }
}
