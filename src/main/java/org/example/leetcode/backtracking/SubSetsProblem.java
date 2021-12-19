package org.example.leetcode.backtracking;

import java.util.*;

/**
 *
 * @author lichuan
 */
public class SubSetsProblem {

    /**
     * 子集问题一
     *
     *78. 子集 https://leetcode-cn.com/problems/subsets/
     * NC27 集合的所有子集 https://www.nowcoder.com/practice/c333d551eb6243e0b4d92e37a06fbfc9?tpId=190&&tqId=35344&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
     *
     * 参考： https://leetcode-cn.com/problems/subsets/solution/dai-ma-sui-xiang-lu-78-zi-ji-hui-su-sou-6yfk6/
     */

    /**
     * 方法一： 递归+回溯
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 1) {
            return result;
        }

        Deque<Integer> path = new ArrayDeque<>();

        dfs(nums, 0, path, result);

        return result;
    }

    public void dfs(int[] nums, int begin,
                    Deque<Integer> path, List<List<Integer>> result) {
        //递归遍历的时候，收集所有节点的状态，就是要求的子集集合
        //此代码不能放在if块之后，因为path保存的是上一次dfs的结果
        result.add(new ArrayList<>(path));

        if (begin >= nums.length) {
            return;
        }

        //子集是无序的,通过不重复选择进行去重
        for (int i = begin; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i + 1, path, result);
            path.removeLast();
        }
    }


    /**
     * 方法二：迭代枚举
     * 逐个枚举，空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合，
     * 追加这个元素，就是新增的子集
     *
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //首先将空集加入结果集中
        res.add(new ArrayList<>());

        if (null == nums || nums.length < 1) {
            return res;
        }
        //先排序
        Arrays.sort(nums);
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<>(res.get(i));
                newSub.add(num);
                res.add(newSub);
            }
        }
        return res;
    }


    /**
     * 子集问题二
     *
     * 90. 子集 II https://leetcode-cn.com/problems/subsets-ii/
     * 参考： https://leetcode-cn.com/problems/subsets-ii/solution/90-zi-ji-iiche-di-li-jie-zi-ji-wen-ti-ru-djmf/
     */
    /**
     * 方法一： 递归+回溯
     * 要去重的是同一树层上的“使用过”，同一树枝上的都是一个组合里的元素，不用去重。
     *
     */
    public List<List<Integer>> subsetsII(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 1) {
            return result;
        }
        //排序是去重的前提
        Arrays.sort(nums);

        Deque<Integer> path = new ArrayDeque<>();

        dfs2(nums, 0, path, result);

        return result;
    }

    public void dfs2(int[] nums, int begin,
                    Deque<Integer> path, List<List<Integer>> result) {
        //递归遍历的时候，收集所有节点的状态，就是要求的子集集合
        //此代码不能放在if块之后，因为path保存的是上一次dfs的结果
        result.add(new ArrayList<>(path));

        if (begin >= nums.length) {
            return;
        }

        //子集是无序的,通过不重复选择进行去重
        for (int i = begin; i < nums.length; i++){
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs2(nums, i + 1, path, result);
            path.removeLast();
        }
    }
}
