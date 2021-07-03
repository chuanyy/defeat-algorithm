package org.example.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. 二叉树的层序遍历 II https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/submissions/
 */
public class LevelOrder2Problem {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>>  result = new LinkedList<>();
        if (null == root) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            //保存当前层的节点
            List<Integer> level = new ArrayList<>();
            //当前层的节点个数
            int curLevelSize = queue.size();

            for (int i = 0; i < curLevelSize; i++) {
                TreeNode curNode = queue.poll();
                level.add(curNode.val);

                //加入下一层节点到queue
                if (null != curNode.left) {
                    queue.offer(curNode.left);
                }
                if (null != curNode.right) {
                    queue.offer(curNode.right);
                }
            }
            //别忘了加入及如果集合
            result.add(0, level);
        }

        return result;
    }
}
