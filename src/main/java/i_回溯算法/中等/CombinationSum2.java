package i_回溯算法.中等;

import java.util.*;

/**
 * @author yang 2021-11-19 9:57
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 关键步骤
        Stack<Integer> path = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(candidates, target, path, 0, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param target     表示剩余，这个值一开始等于 target
     * @param path       从根结点到叶子结点的路径
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int target, Stack<Integer> path, int begin, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1] 肯定也小于 0，因此用 break。作用是提高效率
            if (target - candidates[i] < 0)
                break;

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，结果一定发生重复，因此跳过，用 continue。作用候选数组是只能使用一次
            if (i > begin && candidates[i] == candidates[i - 1])
                continue;

            path.push(candidates[i]);

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, target - candidates[i], path, i + 1, res);

            path.pop();
        }
    }
}

/*
40. 组合总和 II
https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中 只能使用一次 。
注意：解集不能包含重复的组合。

示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[[1,1,6],
 [1,2,5],
 [1,7],
 [2,6]]

示例 2:
输入: candidates = [2,5,2,1,2], target = 5,
输出:
[[1,2,2],
 [5]]
 */
