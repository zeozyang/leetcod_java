package i_回溯算法.中等;

import java.util.*;

/**
 * @author yang 2021-11-24 16:30
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        Stack<Integer> path = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();

        // 从 1 开始是题目的设定
        dfs(n, k, path, 1, res);
        return res;
    }

    private void dfs(int n, int k, Stack<Integer> path, int begin, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = begin; i <= n; i++) {
            path.push(i);

            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, path, i + 1, res);

            path.pop();
        }
    }
}

/*
77. 组合
https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
你可以按 任何顺序 返回答案。

示例 1：
输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

示例 2：
输入：n = 1, k = 1
输出：[[1]]
 */