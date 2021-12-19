package org.example.leetcode.backtracking;

import java.util.*;

/**
 * 组合总数
 * @author lichuan
 */
public class CombinationSumProblem {

    /**
     * 39. 组合总和 https://leetcode-cn.com/problems/combination-sum/
     *
     * 参考：https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == candidates || candidates.length < 1) {
            return result;
        }

        int len = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        // 排序是剪枝的前
        Arrays.sort(candidates);
        dfs(candidates, 0, len, target, path, result);

        return result;
    }

    public void dfs(int[] candidates, int begin, int len, int target,
                    Deque<Integer> path, List<List<Integer>> result) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            //剪枝
            //前提时候选数组已按升序排列
            if (target - candidates[i] < 0) {
                break;
            }

            path.add(candidates[i]);
            dfs(candidates, i, len, target - candidates[i], path, result);
            path.removeLast();
        }
    }

    /**
     * 40. 组合总和 II  https://leetcode-cn.com/problems/combination-sum-ii/
     *
     * 参考：https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == candidates || candidates.length < 1) {
            return result;
        }

        int len = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        // 排序是剪枝的前
        Arrays.sort(candidates);
        dfs2(candidates, 0, len, target, path, result);

        return result;
    }

    public void dfs2(int[] candidates, int begin, int len, int target,
                    Deque<Integer> path, List<List<Integer>> result) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            //大剪枝:减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            //前提时候选数组已按升序排列
            if (target - candidates[i] < 0) {
                break;
            }

            //小剪枝:同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs2(candidates, i + 1, len, target - candidates[i], path, result);
            path.removeLast();
        }
    }
}
