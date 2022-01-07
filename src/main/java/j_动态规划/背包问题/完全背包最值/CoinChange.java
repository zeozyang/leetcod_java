package j_动态规划.背包问题.完全背包最值;

import java.util.Arrays;

/**
 * @author yang 2021-11-26 9:33
 */

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; //dp[i]: 换到面值i所用最少硬币个数，dp数组的长度一般是背包容量 + 1
        Arrays.fill(dp, amount + 1); //给dp数组每个位置赋初值为特殊值 amount + 1，一个正常永远页达不到的值。

        dp[0] = 0; //base case
        for (int coin : coins) //遍历选择
            for (int i = coin; i <= amount; i++) //遍历状态
                dp[i] = Math.min(dp[i], dp[i - coin] + 1); //状态转移方程为 dp[i - coin] + 1

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}

/*
主站 322. 零钱兑换
    完全背包: 外循环nums,内循环target,target正序且target>=nums[i]；
    最值问题: dp[i] = max/min(dp[i], dp[i-nums]+1) 或 dp[i] = max/min(dp[i], dp[i-num]+nums);
https://leetcode-cn.com/problems/coin-change/solution/yi-pian-wen-zhang-chi-tou-bei-bao-wen-ti-sq9n/
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
你可以认为每种硬币的数量是无限的。

示例 1：
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1

示例 2：
输入：coins = [2], amount = 3
输出：-1

示例 3：
输入：coins = [1], amount = 0
输出：0

示例 4：
输入：coins = [1], amount = 1
输出：1

示例 5：
输入：coins = [1], amount = 2
输出：2
 */
