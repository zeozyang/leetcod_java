package j_动态规划.路径问题.基础;

import java.util.Arrays;

/**
 * @author yang 2022-01-05 17:27
 */
public class MinFallingPathSum2 {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[0][i] = grid[0][i];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE; //这里与上题不同
                for (int k = 0; k < n; k++) {
                    if (k != j)
                        dp[i][j] = Math.min(dp[i - 1][k] + grid[i][j], dp[i][j]); //+ grid[i][j]写到min()里面，而不是外面
                }
            }
        }

        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }
}

/*
1289. 下降路径最小和  II
给你一个整数方阵 arr ，定义「非零偏移下降路径」为：从 arr 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
请你返回非零偏移下降路径数字和的最小值。

示例 1：
输入：arr = [[1,2,3],[4,5,6],[7,8,9]]
输出：13
解释：
所有非零偏移下降路径包括：
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 */