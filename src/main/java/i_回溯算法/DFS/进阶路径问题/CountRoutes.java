package i_回溯算法.DFS.进阶路径问题;

import java.util.Arrays;

/**
 * @author yang 2022-01-06 11:20
 */
public class CountRoutes {
    int mod = 1000000007;

    // 缓存器：用于记录「特定状态」下的结果
    // cache[i][fuel] 代表从位置 i 出发，剩余的油量为 fuel 的前提下，到达目标位置的「路径数量」
    int[][] cache;

    public int countRoutes(int[] ls, int start, int end, int fuel) {
        int n = ls.length;
        // 初始化缓存器,之所以要初始化为 -1,是为了区分「某个状态下路径数量为 0」和「某个状态尚未没计算过」两种情况
        cache = new int[n][fuel + 1];
        for (int i = 0; i < n; i++) // 二维数组全是-1了
            Arrays.fill(cache[i], -1);

        return dfs(ls, start, end, fuel);
    }

    /**
     * 计算「路径数量」
     *
     * @param ls   入参 locations
     * @param u    当前所在位置（ls 的下标）
     * @param end  目标所在位置（ls 的下标）
     * @param fuel 剩余油量
     * @return 在位置 u 出发，油量为 fuel 的前提下，到达 end 的「路径数量」
     */
    int dfs(int[] ls, int u, int end, int fuel) {
        // 如果一步到达不了，说明从位置 u 不能到达 end 位置
        // 将结果 0 写入缓存器并返回
        int need = Math.abs(ls[u] - ls[end]);
        if (need > fuel)
            return cache[u][fuel] = 0;

        // 如果缓存器中已经有答案，直接返回
        if (cache[u][fuel] != -1)
            return cache[u][fuel];

        int n = ls.length;
        // 计算油量为 fuel，从位置 u 到 end 的路径数量
        // 由于每个点都可以经过多次，如果 u = end，那么本身就算一条路径
        int sum = u == end ? 1 : 0;
        for (int i = 0; i < n; i++) {
            if (i != u) { // 下一个城市不能是现在所在的城市
                need = Math.abs(ls[i] - ls[u]);
                if (fuel >= need) {
                    sum += dfs(ls, i, end, fuel - need);
                    sum %= mod;
                }
                // 之所以不用回溯，是因为每个城市可以经过多次。
            }
        }
        return cache[u][fuel] = sum;
    }
}

/*
1575. 统计所有可行路径
给你一个 互不相同 的整数数组，其中 locations[i] 表示第 i 个城市的位置。同时给你 start，finish 和 fuel 分别表示出发城市、目的地城市和你初始拥有的汽油总量
每一步中，如果你在城市 i ，你可以选择任意一个城市 j ，满足  j != i 且 0 <= j < locations.length ，并移动到城市 j 。从城市 i 移动到 j 消耗的汽油量为 |locations[i] - locations[j]|，|x| 表示 x 的绝对值。
请注意， fuel 任何时刻都 不能 为负，且你 可以 经过任意城市超过一次（包括 start 和 finish ）。
请你返回从 start 到 finish 所有可能路径的数目。
由于答案可能很大， 请将它对 10^9 + 7 取余后返回。

示例 1：
输入：locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
输出：4
解释：以下为所有可能路径，每一条都用了 5 单位的汽油：
1 -> 3
1 -> 2 -> 3
1 -> 4 -> 3
1 -> 4 -> 2 -> 3

示例 2：
输入：locations = [4,3,1], start = 1, finish = 0, fuel = 6
输出：5
解释：以下为所有可能的路径：
1 -> 0，使用汽油量为 fuel = 1
1 -> 2 -> 0，使用汽油量为 fuel = 5
1 -> 2 -> 1 -> 0，使用汽油量为 fuel = 5
1 -> 0 -> 1 -> 0，使用汽油量为 fuel = 3
1 -> 0 -> 1 -> 0 -> 1 -> 0，使用汽油量为 fuel = 5

示例 3：
输入：locations = [5,2,1], start = 0, finish = 2, fuel = 3
输出：0
解释：没有办法只用 3 单位的汽油从 0 到达 2 。因为最短路径需要 4 单位的汽油。

示例 4 ：
输入：locations = [2,1,5], start = 0, finish = 0, fuel = 3
输出：2
解释：总共有两条可行路径，0 和 0 -> 1 -> 0 。

示例 5：
输入：locations = [1,2,3], start = 0, finish = 2, fuel = 40
输出：615088286
解释：路径总数为 2615088300 。将结果对 10^9 + 7 取余，得到 615088286 。
 */