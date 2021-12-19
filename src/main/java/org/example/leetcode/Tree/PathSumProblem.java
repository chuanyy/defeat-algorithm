package org.example.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 113. 路径总和 II https://github.com/doocs/leetcode/blob/main/solution/0100-0199/0113.Path%20Sum%20II/README.md
 */
public class PathSumProblem {

    /**
     * 113. 路径总和 II https://github.com/doocs/leetcode/blob/main/solution/0100-0199/0113.Path%20Sum%20II/README.md
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }
    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            //因为list是引用传递，为了防止递归的时候分支污染，我们要在每个路径
            //中都要新建一个List
            result.add(new ArrayList<>(path));
        }

        dfs(root.left, sum, path, result);
        dfs(root.right, sum, path,result);

        //当递归往下传递的时候他最后还是会往回走，
        //把这个值使用完之后还要把它给移除，这就是回溯
        path.remove(path.size() - 1);
    }


    /**
     * 112. 路径总和 https://leetcode-cn.com/problems/path-sum/
     *
     * NC9 二叉树中是否存在节点和为指定值的路径 https://www.nowcoder.com/practice/508378c0823c423baa723ce448cbfd0c?tpId=190&&tqId=35182&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     *
     * 方法一：递归
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }

        if (null == root.left && null == root.right) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    /**
     * 方法2：迭代
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (null == root) {
            return false;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queueNode.offer(root);
        queueSum.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            Integer curSum = queueSum.poll();
            //遍历到叶子节点，判断路径是否满足
            if (null != node.left && null != node.right) {
                assert curSum != null;
                if (curSum.equals(targetSum) ) {
                    return true;
                }
                continue;
            }

            if (null != node.left) {
                queueNode.offer(node.left);
                queueSum.offer(node.left.val);
            }

            if (null != node.right) {
                queueNode.offer(node.right);
                queueSum.offer(node.right.val);
            }
        }

        return false;
    }

}
