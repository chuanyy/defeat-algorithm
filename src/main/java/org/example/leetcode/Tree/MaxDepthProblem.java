package org.example.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度 https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepthProblem {

    //方法一：递归遍历
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        //二叉树的最大深度等于左子树、右子树深度的最大值 + 1（根节点）
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


   //方法一 ： 使用层序遍历
   public int maxDepth2(TreeNode root) {
       if (null == root) {
           return 0;
       }

       int depth = 0;

       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);

       while (!queue.isEmpty()) {
           //当前层的节点个数
           int curLevelSize = queue.size();
           depth++;

           for (int i = 0; i < curLevelSize; i++) {
               TreeNode curNode = queue.poll();
               //加入下一层节点到queue
               if (null != curNode.left) {
                   queue.offer(curNode.left);
               }
               if (null != curNode.right) {
                   queue.offer(curNode.right);
               }
           }
       }

       return depth;
   }
}
