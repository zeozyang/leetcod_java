package j_动态规划.子串与子序列.子序列;

import java.util.Arrays;

/**
 * @author yang 2022-01-12 9:05
 */
public class LengthOfLIS { // 最长递增子序列
    public int lengthOfLIS(int[] nums) { // 动态规划解法
        int[] dp = new int[nums.length]; // dp[i]：以 nums[i] 结尾的递增子序列的长度。
        int res = 1;

        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public int lengthOfLISNlogN(int[] nums) { // 贪心解法+二分查找，时间复杂度比较低
        int[] tails = new int[nums.length]; // tails[i]：长度为 i + 1 的最长上升子序列的末尾元素的最小值

        int res = 0; // res 为 tails 当前长度
        for (int num : nums) {
            int i = 0, j = res;
            while (i < j) { // 查找第一个大于等于num的值并取代它
                int m = (i + j) / 2;
                if (tails[m] < num)
                    i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if (res == j) //如果查到的下标为 tails 当前长度，也就是有效下标范围 + 1，就扩容tails
                res++;
        }
        return res;
    }
}

/*
300. 最长递增子序列
https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4

示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1
 */