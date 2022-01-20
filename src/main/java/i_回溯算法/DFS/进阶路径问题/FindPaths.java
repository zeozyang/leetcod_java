package i_回溯算法.DFS.进阶路径问题;

/**
 * @author yang 2022-01-19 11:38
 */
public class FindPaths {
    int mod = (int) 1e9 + 7;
    long[][][] cache;// 缓存器：用于记录「特定状态」下的结果
    // cache[i][j][maxMove] 代表从位置 i, j 出发，剩余的步数为 fuel 的前提下，出界的路径数。

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new long[m][n][maxMove + 1]; //注意这里用的是long数组，应为答案可能会非常大。
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k <= maxMove; k++)
                    cache[i][j][k] = -1;

        return (int) dfs(m, n, startRow, startColumn, maxMove);
    }

    long dfs(int m, int n, int startRow, int startColumn, int maxMove) {
        //当前到达了棋盘外的位置，说明找到了一条出界路径，返回 1
        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n)
            return 1;
        else if (maxMove == 0) //在条件 1 不满足的前提下，当剩余步数为 0（不能再走下一步），说明没有找到一条合法的出界路径，返回 0。
            return cache[startRow][startColumn][maxMove] = 0;

        // 如果缓存器中已经有答案，直接返回
        if (cache[startRow][startColumn][maxMove] != -1)
            return cache[startRow][startColumn][maxMove];

        return cache[startRow][startColumn][maxMove]
                = (dfs(m, n, startRow - 1, startColumn, maxMove - 1)
                + dfs(m, n, startRow + 1, startColumn, maxMove - 1)
                + dfs(m, n, startRow, startColumn - 1, maxMove - 1)
                + dfs(m, n, startRow, startColumn + 1, maxMove - 1))
                % mod;
    }
}

/*
576. 出界的路径数
给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。

示例 1：
输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
输出：6

示例 2：
输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
输出：12
 */