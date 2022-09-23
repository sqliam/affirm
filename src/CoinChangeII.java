import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * http://www.cnblogs.com/grandyang/p/7669088.html
 *
 * Similar: https://leetcode.com/articles/coin-change/
 * ou are given coins of different denominations and a total amount of money. Write a function to compute the
 * number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 *
 * Note: You can assume that
 *
 * 0 <= amount <= 5000
 * 1 <= coin <= 5000
 * the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 *
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 *
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 *
 *
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 * This is a classic knapsack problem. Honestly,
 *
 * dp[i][j] : the number of combinations to make up amount j by using the first i types of coins
 * State transition:
 *
 * not using the ith coin, only using the first i-1 coins to make up amount j, then we have dp[i-1][j] ways.
 * using the ith coin, since we can use unlimited same coin, we need to know how many ways to make up
 * amount j - coins[i-1] by using first i coins(including ith), which is dp[i][j-coins[i-1]]
 * Initialization: dp[i][0] = 1
 *
 */
public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }

    @Test
    public void test()
    {
        assertEquals( 4, change(5,new int[]{ 1, 2, 5 } ) );
        assertEquals( 0, change(3,new int[]{ 2} ) );
    }
}
