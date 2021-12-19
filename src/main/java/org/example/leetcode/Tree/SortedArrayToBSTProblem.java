package org.example.leetcode.Tree;

import java.util.Random;

public class SortedArrayToBSTProblem {

    Random rand = new Random();

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public TreeNode dfs(int[] nums, int low, int high) {
        //递归终止条件
        if(low > high) {
            return null;
        }

        //利用二分查找法确保高度平衡二叉树
        int mid = low + (high - low + rand.nextInt(2) ) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        //递归的构建 root 的左子树与右子树。
        root.left = dfs(nums, low, mid - 1);
        root.right = dfs(nums, mid + 1, high);

        return root;
    }
}
