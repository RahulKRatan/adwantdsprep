package InterviewPractice.DP;


import java.util.Arrays;

/**
 * Intuition behind solution: Build a dp array to store the fewest number of coins needed to create "i" change (i.e. dp[10] = the fewest number of coins to make 10 cents).
 * Solve all subproblems up to the the nth problem (aka "amount" in this problem) and return the result.
 * Time complexity : O(S*n). On each step the algorithm finds the next F(i)
 * Space complexity : O(S). We use extra space for the memoization table.
 */
public class CoinChange {

    public static int  coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=0;i<=amount;i++){
            for (int j=0;j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        System.out.println(coinChange(coins,11));
    }
}

/* Top Down
public class Solution {

  public int coinChange(int[] coins, int amount) {
    if (amount < 1) return 0;
    return coinChange(coins, amount, new int[amount]);
  }

  private int coinChange(int[] coins, int rem, int[] count) {
    if (rem < 0) return -1;
    if (rem == 0) return 0;
    if (count[rem - 1] != 0) return count[rem - 1];
    int min = Integer.MAX_VALUE;
    for (int coin : coins) {
      int res = coinChange(coins, rem - coin, count);
      if (res >= 0 && res < min)
        min = 1 + res;
    }
    count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
    return count[rem - 1];
  }
}
 */
