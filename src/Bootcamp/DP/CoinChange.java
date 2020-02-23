package Bootcamp.DP;


import java.util.Arrays;

/**
 * Intuition behind solution: Build a dp array to store the fewest number of coins needed to create "i" change (i.e. dp[10] = the fewest number of coins to make 10 cents).
 * Solve all subproblems up to the the nth problem (aka "amount" in this problem) and return the result.
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
