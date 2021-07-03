package org.example.leetcode.Tree;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点 https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 *
 * 参考：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
 * @author lichuan
 */
public class KthLargestProblem {

    //思路：中序遍历的倒序为递减序列

    int res = 0, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    //中序遍历：左中右，倒序：右中左

    private void dfs(TreeNode root) {
        if (null == root) {
            return;
        }
        dfs(root.right);
        if (0 == --k) {
            res = root.val;
            return;
        }
        dfs(root.left);
    }
}
