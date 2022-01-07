package j_动态规划.背包问题.完全背包最值;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yang 2021-12-10 14:18
 */
public class NumSquares {
    public int numSquares(int n) {
        List<Integer> nums = new ArrayList<>();
        double sqrt = Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) { //列出比n小的所有完全平方数，作为动态规划的所有“选择”
            if (i * i <= n)
                nums.add(i * i);
        }
        int[] dp = new int[n + 1]; //dp[i]: 和为 i 的完全平方数的最少数量
        Arrays.fill(dp, n + 1);

        dp[0] = 0;
        for (Integer num : nums)
            for (int i = num; i <= n; i++)
                dp[i] = Math.min(dp[i], dp[i - num] + 1);

        return dp[n];
    }
}

/*
279. 完全平方数
    完全背包: 外循环nums,内循环target,target正序且target>=nums[i]；
    最值问题: dp[i] = max/min(dp[i], dp[i-nums]+1) 或 dp[i] = max/min(dp[i], dp[i-num]+nums);
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

示例 1：
输入：n = 12
输出：3
解释：12 = 4 + 4 + 4

示例 2：
输入：n = 13
输出：2
解释：13 = 4 + 9
 */