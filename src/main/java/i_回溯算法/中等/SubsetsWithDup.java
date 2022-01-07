package i_回溯算法.中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author yang 2021-11-26 8:56
 */
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> path = new Stack<>();
        int begin = 0;
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, path, begin, res);
        return res;
    }

    private void dfs(int[] nums, Stack<Integer> path, int begin, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));

        for (int i = begin; i < nums.length; i++) {
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，结果一定发生重复，因此跳过，用 continue
            if (i > begin && nums[i] == nums[i - 1])
                continue;

            path.push(nums[i]);
            dfs(nums, path, i + 1, res);
            path.pop();
        }
    }
}

/*
90. 子集 II
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

示例 1：
输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
  // [[],[1],[1,2],[1,2,2],[1,2],[2],[2,2],[2]]

示例 2：
输入：nums = [0]
输出：[[],[0]]
 */