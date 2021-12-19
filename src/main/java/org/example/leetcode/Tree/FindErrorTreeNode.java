package org.example.leetcode.Tree;

/**
 * NC58 找到搜索二叉树中两个错误的节点
 * https://www.nowcoder.com/practice/4582efa5ffe949cc80c136eeb78795d6?tpId=190&&tqId=35399&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 *  解题思路：
 *     因为二叉搜索树的中序遍历是正序数组，所以直接进行中序遍历，遍历的过程中直接找出异常值
 *     分析结果可得，必然是一个较大的异常值交换到了前面，较小的异常值数放到了后面，
 *     所以遍历的过程中出现的第一个当前值小于前一个值的情况时，前一个值即为要找的较大的异常值，
 *     而出现的最后一个 当前值小于前一个值的情况时，当前值才是我们要找的较小的异常值，
 *     所以在遍历过程中需要覆盖前面所求的较小值。
 * @author lichuan
 */
public class FindErrorTreeNode {
    int[] res = new int[2];
    int index = 1;
    TreeNode pre = null;
    public int[] findError (TreeNode root) {
        if (null == root) {
            return res;
        }

        findError(root.left);
        //遍历第一个节点时
        if (null == pre) {
            pre = root;
        }

        if(index == 1 && root.val < pre.val) {
            res[index] = pre.val;
            index--;
        }
        if(index == 0 && root.val < pre.val) {
            res[index] = root.val;
        }

        pre = root;
        findError(root.right);
        return res;
    }
}
