package org.example.leetcode.dfs;

/**
 * dfs解决岛屿问题
 * 参考 https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 * @author lichuan
 */
public class IslandsProblem {

    /**
     * 判断坐标（r,c）是否在网格中
     */
    public boolean inArea(char[][] grid, int row, int column) {
        return 0 <= row && row < grid.length && 0 <= column && column < grid[0].length;
    }

    public void dfs(char[][] grid, int row, int column) {
        // 判断 base case
        // 如果坐标 (r, c) 超出了网格范围，直接返回
        if (!inArea(grid, row, column)) {
            return;
        }

        // 如果这个格子不是岛屿，直接返回
        if (grid[row][column] != '1') {
            return;
        }
        // 将格子标记为「已遍历过」
        grid[row][column] = '2';


        //访问上、下、左、右四个相邻节点
        dfs(grid, row - 1, column);
        dfs(grid, row + 1, column);
        dfs(grid, row, column - 1);
        dfs(grid, row, column + 1);

    }

    /**
     * 200. 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
     *
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int islandNum = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++islandNum;
                    dfs(grid, r, c);
                }
            }
        }

        return islandNum;
    }
}
