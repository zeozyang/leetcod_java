package g_贪心算法.BFS;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yang 2022-01-29 15:27
 */
public class HighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] ans = new int[m][n];
        Deque<int[]> queue = new ArrayDeque<>(); // 注意多源dfs都是用的队列
        // 把所有源点入队，并初始化返回矩阵。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1)
                    queue.push(new int[]{i, j});
                ans[i][j] = isWater[i][j] == 1 ? 0 : -1; // 初始化为-1很关键
            }
        }

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.pollFirst();
            int dx = poll[0], dy = poll[1];
            for (int[] dir : dirs) {
                int nx = dx + dir[0], ny = dy + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (ans[nx][ny] != -1) continue;
                ans[nx][ny] = ans[dx][dy] + 1;
                queue.addLast(new int[]{nx, ny});
            }
        }
        return ans;
    }
}

/*
1765. 地图中的最高点  多源 BFS   以 1162. 地图分析 为基础
https://leetcode-cn.com/problems/map-of-highest-peak/
 */