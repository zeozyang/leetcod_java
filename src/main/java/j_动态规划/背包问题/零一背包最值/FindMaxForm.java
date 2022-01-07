package j_动态规划.背包问题.零一背包最值;

/**
 * @author yang 2021-12-07 10:08
 */
public class FindMaxForm {
    //m和n共同构成背包容量，但在一次接收参收后背包容量是不会变的，所以这题不是分组背包问题。
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1]; //dp[i][j] 表示使用 i 个 0 和 j 个 1 最多可以得到的最大子集的长度。

        dp[0][0] = 0; //base case
        for (String str : strs) {
            int[] zerosOnes = getZerosOnes(str);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = m; j >= zeros; j--)
                for (int k = n; k >= ones; k--)
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
        }

        return dp[m][n];
    }

    public int[] getZerosOnes(String str) { //获得当前字符串中0和1的个数
        int[] zerosOnes = new int[2];
        for (char c : str.toCharArray())
            zerosOnes[c - '0'] += 1;
        return zerosOnes;
    }
}

/*
474. 一和零    典型的0-1背包问题：求容量为i的背包，最多能装多少。
    0/1背包: 外循环nums,内循环target,target倒序且target>=nums[i];
    最值问题: dp[i] = max/min(dp[i], dp[i-nums]+1) 或 dp[i] = max/min(dp[i], dp[i-num]+nums);
https://leetcode-cn.com/problems/ones-and-zeroes/solution/dong-tai-gui-hua-zhuan-huan-wei-0-1-bei-bao-wen-ti/
给你一个 二进制字符串数组 strs 和两个整数 m 和 n 。
请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。

示例 1：
输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出：4
解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。

示例 2：
输入：strs = ["10", "0", "1"], m = 1, n = 1
输出：2
解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 */
