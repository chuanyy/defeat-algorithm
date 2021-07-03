package org.example.leetcode.Tree;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 *  https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 *
 *  参考：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
 */
public class VerifyPostorderProblem {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j){
            return true;
        }
        int p = i;
        //左子树区间 [i, m - 1][i,m−1] 内的所有节点都应 <postorder[j] 。而第 1.划分左右子树 步骤已经保证左子树区间的正确性，因此只需要判断右子树区间即可
        while(postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        //右子树区间 [m, j-1][m,j−1] 内的所有节点都应 >postorder[j] 。实现方式为遍历，当遇到postorder[j]≤postorder[j] 的节点则跳出；则可通过 p=j 判断是否为二叉搜索树
        while(postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
