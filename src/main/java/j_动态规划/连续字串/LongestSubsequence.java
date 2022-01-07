package j_动态规划.连续字串;

import java.util.HashMap;

/**
 * @author yang 2021-12-28 8:51
 */
public class LongestSubsequence { // 与之前的子子串题不同，这题可以删除元素
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 1;
        HashMap<Integer, Integer> dp = new HashMap<>(); //dp[i]：以arr[i]结尾的最长等差子序列的长度
        for (int i : arr) {
            dp.put(i, dp.getOrDefault(i - difference, 0) + 1);
            ans = Math.max(ans, dp.get(i));
        }
        return ans;
    }
}

/*
1218. 最长定差子序列
给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。

示例 1：
输入：arr = [1,2,3,4], difference = 1
输出：4
解释：最长的等差子序列是 [1,2,3,4]。

示例 2：
输入：arr = [1,3,5,7], difference = 1
输出：1
解释：最长的等差子序列是任意单个元素。

示例 3：
输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
输出：4
解释：最长的等差子序列是 [7,5,3,1]。
 */