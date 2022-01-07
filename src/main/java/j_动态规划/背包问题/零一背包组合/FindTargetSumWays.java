package j_动态规划.背包问题.零一背包组合;

/**
 * @author yang 2021-12-07 11:44
 */
public class FindTargetSumWays {
    // 数组和sum, 目标和target, 添加‘-’的 元素之和neg, 添加‘+’的元素之和为sum-neg, 则sum-2neg=target, 那么neg=(sum-target)/2
    // 问题转化成在数组 nums 中选取若干元素，使得这些元素之和等于 neg，计算选取元素的方案数。
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) return 0;
        int neg = diff / 2;
        int[] dp = new int[neg + 1]; //dp[i]:填满i这么大容积的包，有dp[i]种方法

        dp[0] = 1; //当没有任何元素可以选取时，元素和只能是 0，对应的方案数是 1
        for (int num : nums)
            for (int i = neg; i >= num; i--)
                dp[i] += dp[i - num];

        return dp[neg];
    }
}

/*
494. 目标和
    0/1背包：外循环nums, 内循环target, target倒序且target>=nums[i];
    组合问题：dp[i]+=dp[i-num];
给你一个整数数组 nums 和一个整数 target 。
向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

示例 1：
输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3

示例 2：
输入：nums = [1], target = 1
输出：1
 */