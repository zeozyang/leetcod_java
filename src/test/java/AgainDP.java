import java.util.Arrays;

/**
 * @author yang 2021-12-10 9:26 2022-1-21 10:25 重作
 */
public class AgainDP {
    //零钱兑换：给定amount，求用任意数量不同面值的零钱换到amount所用的最少数量。
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
