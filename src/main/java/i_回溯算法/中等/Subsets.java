package i_回溯算法.中等;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yang 2021-11-25 9:16
 */
public class Subsets { // 组合
    public List<List<Integer>> subsets(int[] nums) {
        Stack<Integer> path = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, path, 0, res);
        return res;
    }

    private void dfs(int[] nums, Stack<Integer> path, int begin, List<List<Integer>> res) {
        // 没有显式的递归终止
        res.add(new ArrayList<>(path));

        for (int i = begin; i < nums.length; i++) {
            path.push(nums[i]);

            dfs(nums, path, i + 1, res);

            path.pop();
        }
    }
}

/*
78. 子集
https://leetcode-cn.com/problems/subsets/solution/hui-su-python-dai-ma-by-liweiwei1419/
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

示例 2：
输入：nums = [0]
输出：[[],[0]]
 */