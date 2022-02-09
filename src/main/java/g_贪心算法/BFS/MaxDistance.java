package g_贪心算法.BFS;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yang 2022-01-29 15:36
 */
public class MaxDistance {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Deque<int[]> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>(); // 格子对应的离陆地的距离
        // 先把所有的陆地都入队，因为图可以有多个源点，所以首先需要把多个源点都入队
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    d.add(new int[]{i, j});
                    map.put(i * n + j, 0);
                }
            }
        }

        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        int ans = -1;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx * n + dy);
            for (int[] dir : dirs) {
                int nx = dx + dir[0], ny = dy + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (grid[nx][ny] != 0) continue;
                grid[nx][ny] = step + 1;
                d.addLast(new int[]{nx, ny});
                map.put(nx * n + ny, step + 1);
                ans = Math.max(ans, step + 1);
            }
        }
        return ans;
    }
}

/*
1162. 地图分析
https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 */