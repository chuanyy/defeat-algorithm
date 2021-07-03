package org.example.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrderProblem {
   public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>>  result = new ArrayList<>();
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
           result.add(level);
       }

       return result;
   }


   public List<List<Integer>> levelOrder2(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
       if (null == root) {
           return result;
       }

       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       while (!queue.isEmpty()) {
           //保存当前层的节点
           List<Integer> level = new ArrayList<>();
           //当前层节点个数
           int curLevelSize = queue.size();

           for (int i = 0; i < curLevelSize; i++) {
               TreeNode node = queue.poll();
               level.add(node.val);

               //将当前节点的左右节点加入到queue，以便下一层输出
               if (null != node.left) {
                   queue.offer(node.left);
               }
               if (null != node.right) {
                   queue.offer(node.right);
               }
           }

           //将当前层加入结果集
           result.add(level);
       }
       return result;
   }
}
