package 弱智一样的每日一题;

import java.util.HashMap;

/**
 * @author yang 2022-02-18 9:34
 */
public class FindCenter {
    public int findCenter(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>(); //v:k出现的次数
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                map.put(edges[i][j], map.getOrDefault(edges[i][j], 0) + 1);
                if (map.get(edges[i][j]) == 2) return edges[i][j];
            }
        }
        return -1;
    }
}

/*
1791. 找出星型图的中心节点    22/2/18  每日一题
有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。

示例 1：
输入：edges = [[1,2],[2,3],[4,2]]
输出：2
解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。

示例 2：
输入：edges = [[1,2],[5,1],[1,3],[1,4]]
输出：1
 */