package j_动态规划.连续字串;

/**
 * @author yang 2021-12-17 16:48
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; //dp[i]：以 nums[i] 结尾的连续子数组的最大和。

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0)
                dp[i] = dp[i - 1] + nums[i]; //状态转移方程
            else dp[i] = nums[i];
        }

        int max = nums[0];
        for (int i : dp)
            max = Math.max(max, i);
        return max;
    }
}

/*
53. 最大子序和
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。

示例 2：
输入：nums = [1]
输出：1
 */