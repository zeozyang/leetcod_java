package g_贪心算法;

/**
 * @author yang 2021-12-13 16:09
 */
public class MaxIncreaseKeepingSkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] hRows = new int[n];
        int[] hLines = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hRows[i] = Math.max(grid[i][j], hRows[i]);
                hLines[j] = Math.max(grid[i][j], hLines[j]);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res += Math.min(hRows[i], hLines[j]) - grid[i][j];

        return res;
    }
}

// 807. 保持城市天际线
// https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline/solution/gong-shui-san-xie-jian-dan-tan-xin-yun-y-2f47/