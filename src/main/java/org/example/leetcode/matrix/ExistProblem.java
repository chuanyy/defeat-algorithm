package org.example.leetcode.matrix;

/**
 * 剑指 Offer 12. 矩阵中的路径 https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 *
 * 参考：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
 */
public class ExistProblem {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k]) {
            return false;
        }
        //递归终止条件（ k = len(word) - 1 ，即字符串 word 已全部匹配）
        if(k == words.length - 1) {
            return true;
        }
        //标记为已搜索过
        board[i][j] = '#';
        boolean res = dfs(board, words, i + 1, j, k + 1) ||
                      dfs(board, words, i, j + 1,k + 1 ) ||
                      dfs(board, words, i - 1, j, k + 1) ||
                      dfs(board, words, i , j - 1, k + 1);
        //还原当前矩阵元素
        board[i][j] = words[k];
        return res;
    }
}
