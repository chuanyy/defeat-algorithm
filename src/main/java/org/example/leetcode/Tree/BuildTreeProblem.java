package org.example.leetcode.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 *  105. 从前序与中序遍历序列构造二叉树
 *
 *  https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class BuildTreeProblem {

    //保存中序遍历中节点值与数组索引的映射
    private Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int nodeNum = inorder.length;
        map = new HashMap<>(nodeNum);
        for (int i = 0; i < nodeNum; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeCore(preorder, inorder, 0, nodeNum - 1, 0, nodeNum - 1);
    }

    private TreeNode buildTreeCore(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        //在中序遍历中定位根节点的位置
        int inRootIndex = map.get(preorder[preLeft]);
        TreeNode root = new TreeNode(preorder[preLeft]);
        //计算出左子树节点的个数
        int leftNum = inRootIndex - inLeft;

        //递归构造左子树和右子树
        root.left = buildTreeCore(preorder, inorder, preLeft + 1, preLeft + leftNum, inLeft, inRootIndex - 1);
        root.right = buildTreeCore(preorder, inorder, preLeft + leftNum + 1, preRight, inRootIndex + 1, inRight);

        return root;
    }
}
