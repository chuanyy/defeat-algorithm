package org.example.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图 https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *  稍微改造一下，可得二叉树的左视图
 * @author lichuan
 */
public class RightSideViewProblem {

    /**
     * 方法一
     * 利用二叉树的层序遍历，记录每一层的最后一个节点即为答案集
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (null != cur.left) {
                    queue.offer(cur.left);
                }
                if (null != cur.right) {
                    queue.offer(cur.right);
                }

                if (i == levelSize - 1) {
                    result.add(cur.val);
                }
            }
        }

        return result;
    }


    /**
     * 方法二 dfs
     * 我们按照 「根结点 -> 右子树 -> 左子树」 的顺序访问，就可以保证每层都是最先访问最右边的节点的。
     *
     * （与先序遍历 「根结点 -> 左子树 -> 右子树」 正好相反，先序遍历每层最先访问的是最左边的节点）
     *
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        // 从根节点开始访问，根节点深度是0
        dfs(root, 0, result);

        return result;
    }

    private void dfs(TreeNode root, int depth, List<Integer> result) {
        if (null == root) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
        if (depth == result.size()) {
            result.add(root.val);
        }
        depth++;
        dfs(root.right, depth, result);
        dfs(root.left, depth, result);
    }

}
