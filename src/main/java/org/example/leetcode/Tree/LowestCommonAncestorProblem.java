package org.example.leetcode.Tree;

/**
 * 236. 二叉树的最近公共祖先 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *  参考：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/ 北冥有一鲲的评论
 * @author lichuan
 */
public class LowestCommonAncestorProblem {

    //**************************方法二，递归一次******************************************************

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归终止条件
        if (root == null || root == p || root == q) {
            return root;
        }

        //在左子树中搜寻p、q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //在右子树中搜寻p、q
        TreeNode rigth = lowestCommonAncestor(root.right, p, q);
        //如果怕p、q都不在左子树中，说明这两个节点在当前节点的右子树上，我们只需要返回右子树查找的结果即可
        if (left == null) {
            return rigth;
        }
        //如果怕p、q都不在右子树中，说明这两个节点在当前节点的左子树上，我们只需要返回左子树查找的结果即可
        if (rigth == null) {
            return left;
        }
        //如果left和right都不为空，说明这两个节点一个在当前节点的左子树上一个在当前介节点的右子树上，
        //我们只需要返回当前结点即可。
        return root;
    }


    /**
     * 牛客网
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        TreeNode node = CommonAncestor(root, o1, o2);
        return null == node ? -1 : node.val;
    }

    public TreeNode CommonAncestor (TreeNode root, int o1, int o2) {
        //递归终止条件
        if (null == root || o1 == root.val || o2 == root.val) {
            return root;
        }
        TreeNode left = CommonAncestor(root.left, o1, o2);
        TreeNode right = CommonAncestor(root.right, o1, o2);
        if (left == null) {  // 都在右侧
            return right;
        }
        if (right == null) { // 都在左侧
            return left;
        }
        return root; // 在左右两侧
    }

    //**************************方法一，需要递归两次******************************************************
    //第一次递归，判断p、节点是否存在于树中
    //第二次递归，找出最近公告祖先
    //因为p、q节点一定存在，此方法浪费了大量的时间


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }
        // 如果p,q为根节点，则公共祖先为根节点
        if (p == root || q == root) {
            return root;
        }
        // 如果去p,q都在左子树中，则公共祖先在左子树中查找
        if (isNodeExist(root.left, p) && isNodeExist(root.left, q)) {
            return lowestCommonAncestor2(root.left, q, q);
        }
        // 如果p,q都在右子树总，则公共祖先在右子树中查找
        if (isNodeExist(root.right, p) && isNodeExist(root.right, q)) {
            return lowestCommonAncestor2(root.right, p, q);
        }

        //如果p,分属两侧，则公共祖先为根节点
        return root;
    }

    /**
     * 判断节点target是否在以root为根树中
     */
    private boolean isNodeExist(TreeNode root, TreeNode target) {
        if (null == root) {
            return false;
        }
        if(target == root) {
            return true;
        }
        return isNodeExist(root.left, target) || isNodeExist(root.right, target);
    }
}
