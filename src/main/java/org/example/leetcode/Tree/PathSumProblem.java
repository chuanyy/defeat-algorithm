package org.example.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II https://github.com/doocs/leetcode/blob/main/solution/0100-0199/0113.Path%20Sum%20II/README.md
 */
public class PathSumProblem {
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

        //移除最后一个值，向上回溯
        path.remove(path.size() - 1);
    }
}
