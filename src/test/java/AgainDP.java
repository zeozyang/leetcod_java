import java.util.Arrays;

/**
 * @author yang 2021-12-10 9:26
 */
public class AgainDP {
    //主站 322. 零钱兑换
    //     完全背包: 外循环nums,内循环target,target正序且target>=nums[i];
    //     最值问题: dp[i] = max/min(dp[i], dp[i-nums]+1) 或 dp[i] = max/min(dp[i], dp[i-num]+nums);
    // 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    // 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    // 你可以认为每种硬币的数量是无限的。
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    //416. 分割等和子集
    //     0/1背包: 外循环nums,内循环target,target倒序且target>=nums[i];
    //     存在问题: dp[i] = dp[i] || dp[i-num];
    // 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];

        dp[0] = true;
        for (int num : nums)
            for (int i = target; i >= num; i--)
                dp[i] = dp[i] || dp[i - num];

        return dp[target];
    }


    //474. 一和零    典型的0-1背包问题：求容量为i的背包，最多能装多少。
    //     0/1背包: 外循环nums,内循环target,target倒序且target>=nums[i];
    //     最值问题: dp[i] = max/min(dp[i], dp[i-nums]+1) 或 dp[i] = max/min(dp[i], dp[i-num]+nums);
    // 给你一个 二进制字符串数组 strs 和两个整数 m 和 n 。
    // 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 0;
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') zeros += 1;
                else ones += 1;
            }
            for (int i = m; i >= zeros; i--)
                for (int j = n; j >= ones; j--)
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
        }

        return dp[m][n];
    }


    //剑指 Offer 66. 构建乘积数组
    // 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return a;

        int[] lDP = new int[a.length]; //ldp[i]: a[i]左边所有元素的乘积
        int[] rDP = new int[a.length]; //rdp[i]: a[i]右边所有元素的乘积

        lDP[0] = 1;
        rDP[a.length - 1] = 1;
        for (int i = 1; i < a.length; i++)
            lDP[i] = lDP[i - 1] * a[i - 1];
        for (int i = a.length - 2; i >= 0; i--)
            rDP[i] = rDP[i + 1] * a[i + 1];

        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++)
            res[i] = lDP[i] * rDP[i];
        return res;
    }


    //剑指 Offer 48. 最长不含重复字符的子字符串
    // 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
    // public int lengthOfLongestSubstring(String s) {
    //     // 21/12/10 还不确定此题是否是分组零一背包问题
    //     int[] dp = new int[s.length()]; //dp[i]: 到s[i]为止，最长子字符串的长度
    //
    //     dp[0] = 1;
    // }
}
