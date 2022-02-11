package g_贪心算法.BFS;

import java.util.*;

/**
 * @author yang 2022-01-29 15:36
 */
public class MaxDistance {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Deque<int[]> deque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>(); //每个格子对应的离陆地距离
        // 把所有源点如队列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    deque.addLast(new int[]{i, j});
                    map.put(i * n + j, 0);
                }
            }
        }

        int ans = -1;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!deque.isEmpty()) {
            int[] poll = deque.pollFirst();
            int dx = poll[0], dy = poll[1];
            for (int[] dir : dirs) {
                int nx = dx + dir[0], ny = dy + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue; //如果出界就直接换方向
                if (grid[nx][ny] != 0) continue;
                grid[nx][ny] = map.get(dx * n + dy) + 1;
                ans = Math.max(ans, grid[nx][ny]);
                deque.addLast(new int[]{nx, ny});
                map.put(nx * n + ny, grid[nx][ny]);
            }
        }
        return ans;
    }
}

/*
1162. 地图分析
https://leetcode-cn.com/problems/as-far-from-land-as-possible/
你现在手里有一份大小为 n x n 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。如果网格上只有陆地或者海洋，请返回 -1。
 */