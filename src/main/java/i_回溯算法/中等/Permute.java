package i_回溯算法.中等;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yang 2021-11-10 17:09
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, path, used, res);
        return res;
    }

    /**
     * @param nums 要进行全排列的数组
     * @param path 走过的路径
     * @param used 在一次全排列中被用过的元素
     * @param res  所有可能的全排列
     */
        // 1.设计好递归函数的「入参」和「出参」
    private void dfs(int[] nums, Stack<Integer> path, boolean[] used, List<List<Integer>> res) {
        // 2.设置好递归函数的出口（Base Case）
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 3.编写「最小单元」处理逻辑
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) { // 在还未选择的数中依次选择一个元素作为下一个位置的元素。
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
46. 全排列
给定一个不含重复数字的数组nums，返回其所有可能的全排列。你可以按任意顺序返回答案。
https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/

示例 1：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

示例 2：
输入：nums = [0,1]
输出：[[0,1],[1,0]]
 */