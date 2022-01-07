package j_动态规划.背包问题.分组背包.零一背包组合;

/**
 * @author yang 2021-12-29 9:38
 */
public class NumRollsToTarget {
    //一般的背包问题的物品重量是不会变的，这题的骰子却有1-f的可能性。
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1]; //dp[i][j]表示投掷i个骰子点数和为j的方法数

        dp[0][0] = 1;
        for (int i = 1; i <= d; ++i)
            for (int j = 1; j <= f; ++j)
                for (int k = target; k >= j; --k)
                    dp[i][k] = (dp[i][k] + dp[i - 1][k - j]) % 1000000007;

        return dp[d][target];
    }
}

/*
1155. 掷骰子的N种方法
    0/1背包：外循环nums，内循环target。target倒序，循环变量i从target开始，且大于等于num[i]。
    组合问题：dp[i] += dp[i-num];
这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。
我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。

示例 1：
输入：d = 1, f = 6, target = 3
输出：1

示例 2：
输入：d = 2, f = 6, target = 7
输出：6

示例 3：
输入：d = 2, f = 5, target = 10
输出：1

示例 4：
输入：d = 1, f = 2, target = 3
输出：0

示例 5：
输入：d = 30, f = 30, target = 500
输出：222616187

提示：
1 <= d, f <= 30
1 <= target <= 1000
 */