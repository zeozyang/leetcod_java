package j_动态规划.背包问题.零一背包存在性;

/**
 * @author yang 2021-12-02 9:58
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1]; //dp[i]:是否存在 子集的和为i

        dp[0] = true; //base case
        for (int num : nums)  //遍历选择
            for (int i = target; i >= num; i--) //遍历状态
                dp[i] = dp[i] || dp[i - num]; //0-1背包，选与不选

        return dp[target];
    }
}

/*
416. 分割等和子集
    0/1背包: 外循环nums,内循环target,target倒序且target>=nums[i];
    存在问题: dp[i] = dp[i] || dp[i-num];
https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

示例 1：
输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。

示例 2：
输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。
 */
