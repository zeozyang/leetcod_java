package i_回溯算法.DFS;

/**
 * @author yang 2021-07-25 16:14
 */
public class MovingCount {
    int m, n, k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    /**
     * @param i     当前元素在矩阵中的行索引
     * @param j     当前元素在矩阵中的列索引
     * @param si    当前元素在矩阵中的行列索引数位和
     * @param sj    当前元素在矩阵中的列列索引数位和
     * @return      从当前格子出发能够到达多少个格子
     */
    public int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k < si + sj || visited[i][j])
            return 0;
        visited[i][j] = true;
        // 机器人可 仅通过向右和向下移动，访问所有可达解 。1 + 右方搜索的可达解总数 + 下方搜索的可达解总数
        return 1
                + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj)
                + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}

/*
剑指 Offer 13. 机器人的运动范围
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的 数位之和 大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

示例 1：
输入：m = 2, n = 3, k = 1
输出：3

示例 2：
输入：m = 3, n = 1, k = 0
输出：1
 */