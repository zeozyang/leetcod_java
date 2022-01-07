package i_回溯算法.中等;

import java.util.*;

/**
 * @author yang 2021-11-17 9:20
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // 排序（升序或者降序都可以），排序是剪枝的前提
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, path, used, res);
        return res;
    }

    private void dfs(int[] nums, Stack<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!used[i]) { // 在还未选择的数中依次选择一个元素作为下一个位置的元素。

                // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
                // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if ((i > 0 && nums[i] == nums[i - 1]) && !used[i - 1])
                    continue;

                path.push(nums[i]);
                used[i] = true;

                dfs(nums, path, used, res);

                used[i] = false;
                path.pop();
            }
        }
    }
}

/*
47. 全排列 II
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/

示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]

示例 2：
输入：nums = [1,2,3]
输出：
[[1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]]
 */