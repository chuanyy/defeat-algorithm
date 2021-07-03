package org.example.leetcode.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *  https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *  参考：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72/
 *
 */
public class BuildTree2Problem {

    //保存中序遍历中节点值与数组索引的映射
    Map<Integer,Integer> memo;
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int nodeNum = inorder.length;
        memo = new HashMap<>(nodeNum);
        for(int i = 0;i < nodeNum; i++) {
            memo.put(inorder[i], i);
        }
        post = Arrays.copyOf(postorder, nodeNum);
        return buildTree(0, inorder.length - 1, 0, post.length - 1);
    }

    public TreeNode buildTree(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) return null;

        //后续遍历的最后一个节点即为根节点
        int root = post[pe];
        TreeNode node = new TreeNode(root);
        //在中序遍历中定位根节点的位置
        int ri = memo.get(root);

        //递归构造左子树和右子树
        //注意！！！后续遍历左子树的结束位置为 postLeft + inRootIndex - inLeft - 1
        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
        //注意！！！后续遍历右子树的开始位置为 postLeft + inRootIndex - inLeft
        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }
}
