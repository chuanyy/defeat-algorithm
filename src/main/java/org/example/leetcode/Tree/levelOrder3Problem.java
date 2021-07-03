package org.example.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *   剑指 Offer 32 - III. 从上到下之字形打印二叉树 https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 *   参考： https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/solution/mian-shi-ti-32-iii-cong-shang-dao-xia-da-yin-er--3/
 *
 */
public class levelOrder3Problem {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        while(!queue.isEmpty()) {
            //当前层节点个数
            int levelNodeNum = queue.size();
            //当前层节点值集合
            LinkedList<Integer> level = new LinkedList<>();

            for(int i = 1; i <= levelNodeNum; i++) {
                TreeNode node = queue.poll();
                //从层开始，偶数数层，队列尾部
                if(res.size() % 2 == 0) {
                    level.addLast(node.val);
                }
                //奇数层，队列头部
                else {
                    level.addFirst(node.val);
                }

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(level);
        }

        return res;
    }
}
