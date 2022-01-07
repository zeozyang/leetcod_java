package j_动态规划.路径问题.基础;

/**
 * @author yang 2022-01-04 16:38
 */
public class MinPathSum { //这道题是在 62. 不同路径 的基础上，增加了路径成本概念。
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n]; //dp[i][j]：达到下标为i，j的格子的路径上的数字总和的最小值

        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                else if (i > 0)
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                else if (j > 0)
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
/*
64. 最小路径和
给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。

示例 1：
输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。

示例 2：
输入：grid = [[1,2,3],[4,5,6]]
输出：12
 */