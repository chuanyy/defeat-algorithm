package org.example.leetcode.dfs;

import java.util.*;

/**
 * 22. 括号生成 https://leetcode-cn.com/problems/generate-parentheses/
 * NC26 括号生成 https://www.nowcoder.com/practice/c9addb265cdf4cdd92c092c655d164ca?tpId=190&&tqId=35960&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 *
 * 参考 https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 * @author lichuan
 */
public class GenerateParenthesisProblem {

    /**
     * 方法一：深度优先遍历
     *
     * 要点：
     *  1、当前剩余左右括号个数都大于0的时候，才可以产生分支
     *  2、能否产生左分支，只看当前剩余左括号的格式是否大于0
     *  3、能否产生右分支受限于左分支，当剩余右括号个数严格大于左括号个数的时候，才可以产生右分支
     *  4、当剩余的左括号和右括号个数都为0的时候结算
     */
    public ArrayList<String> generateParenthesis (int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }

        dfs("", n, n, res);
        return res;
    }

    /**
     * 做减法
     *
     * @param curStr 当前递归得到的结果
     * @param leftNum   左括号还有几个可以使用
     * @param rightNum  右括号还有几个可以使用
     * @param res    结果集
     */
    public void dfs(String curStr, int leftNum, int rightNum, ArrayList<String> res) {
        if (0 == leftNum && 0 == rightNum) {
            res.add(curStr);
            return;
        }

        //剪枝。左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝
        if (leftNum > rightNum) {
            return;
        }

        if (leftNum > 0) {
            dfs(curStr + "(", leftNum - 1, rightNum, res);
        }
        if (rightNum > 0) {
            dfs(curStr + ")", leftNum, rightNum - 1, res);
        }
    }

    /**
     * 做加法
     *
     * @param curStr 当前递归得到的结果
     * @param leftNum   左括号还有几个可以使用
     * @param rightNum  右括号还有几个可以使用
     * @param res    结果集
     */
    public void dfs2(String curStr, int leftNum, int rightNum, int n, ArrayList<String> res) {
        if (n == leftNum && n == rightNum) {
            res.add(curStr);
            return;
        }

        //剪枝。左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝
        if (leftNum > rightNum) {
            return;
        }

        if (leftNum < n) {
            dfs2(curStr + "(", leftNum + 1, rightNum, n, res);
        }
        if (rightNum < n) {
            dfs2(curStr + ")", leftNum, rightNum + 1, n, res);
        }
    }


    /**
     * 广度优先遍历
     */
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {

            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) {
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }

    class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

}
