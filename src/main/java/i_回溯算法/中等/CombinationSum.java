package i_回溯算法.中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author yang 2021-11-18 10:05
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        Stack<Integer> path = new Stack<>();
        int begin = 0;
        List<List<Integer>> res = new ArrayList<>();

        dfs(candidates, target, path, begin, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int target, Stack<Integer> path, int begin, List<List<Integer>> res) {
        // 由于进入更深层的时候，小于 0 的部分被剪枝，因此递归终止条件值只判断等于 0 的情况
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < candidates.length; i++) {
            // 大剪枝
            if (target - candidates[i] < 0)
                break;

            path.push(candidates[i]);

            // 注意：下一轮搜索的起点是 i，即从每一层的第 2 个结点开始，都不能再搜索之前同一层结点已经使用过的 candidate 里的元素。
            dfs(candidates, target - candidates[i], path, i, res);

            path.pop();
        }
    }
}

/*
39. 组合总和  ==与 322.零钱兑换 不同的地方在于，此题要求 所有 可以使数字和为目标数的组合，而零钱兑换要求的是 最少 的硬币个数
https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
给定一个 无重复元素 的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
candidates 中的数字可以 无限制重复 被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
对于给定的输入，保证和为 target 的唯一组合数少于 150 个。

示例 1：
输入: candidates = [2,3,6,7], target = 7
输出: [[7],[2,2,3]]

示例 2：
输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]

示例 3：
输入: candidates = [2], target = 1
输出: []
 */