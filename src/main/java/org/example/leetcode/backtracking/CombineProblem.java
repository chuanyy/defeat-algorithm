package org.example.leetcode.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合 https://leetcode-cn.com/problems/combinations/
 *
 * 参考：https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
 *
 * @author lichuan
 */
public class CombineProblem {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 1 || k < 1) {
            return result;
        }

        Deque<Integer> path = new ArrayDeque<>();
        // 从 1 开始是题目的设定
        dfs(n, k, 1, path, result);
        return result;
    }

    public void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> result) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <=n; i++) {
            path.add(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, result);
            path.removeLast();
        }
    }
}
