package org.example.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 全排列问题
 *
 * @author lichuan
 */
public class PermuteProblem {

    /**
     * 46. 全排列  https://leetcode-cn.com/problems/permutations/
     * 参考：https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 1) {
            return result;
        }

        int len = nums.length;
        //用来保存数字是否已被使用
        boolean[] used = new boolean[len];
        //使用一个动态数组保存所有可能的全排列
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, result);

        return result;
    }

    /**
     * @param nums   全部数字的数组
     * @param len    数组长度
     * @param depth  当前已使用数组个数
     * @param path   当前排列
     * @param used   数字是否被使用标志
     * @param result 结果集合
     */
    public void dfs(int[] nums, int len, int depth, List<Integer> path,
                    boolean[] used, List<List<Integer>> result) {
        if (len == depth) {
            //由于java对象时引用关系，此处必须new一个新的数组
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, result);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


    /**
     * 47. 全排列 II  https://leetcode-cn.com/problems/permutations-ii/
     * 参考：https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 1) {
            return result;
        }

        int len = nums.length;
        //用来保存数字是否已被使用
        boolean[] used = new boolean[len];
        //使用一个动态数组保存所有可能的全排列
        List<Integer> path = new ArrayList<>();

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        dfs2(nums, len, 0, path, used, result);

        return result;
    }

    /**
     * @param nums   全部数字的数组
     * @param len    数组长度
     * @param depth  当前已使用元素个数
     * @param path   当前排列
     * @param used   数字是否被使用标志
     * @param result 结果集合
     */
    public void dfs2(int[] nums, int len, int depth, List<Integer> path,
                     boolean[] used, List<List<Integer>> result) {
        if (len == depth) {
            //由于java对象时引用关系，此处必须new一个新的数组
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            // used[i - 1] == true，说明同一树支candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 而我们要对同一树层使用过的元素进行跳过
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            //如果同⼀树⽀nums[i]没使⽤过开始处理
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs2(nums, len, depth + 1, path, used, result);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }

    }
}
