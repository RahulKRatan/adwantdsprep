package InterviewPractice.DP;


/**
 * The idea is simple, we start from 1 and go till a number whose square is smaller than or equals to n. For every number x, we recur for n-x. Below is the recursive formula.
 * If n = 1 and x*x <= n
 *
 * dp[i] = min(dp[i], dp[i-square]+1)
 *s
 * https://www.geeksforgeeks.org/minimum-number-of-squares-whose-sum-equals-to-given-number-n/
 * http://yucoding.blogspot.com/2016/12/leetcode-question-perfect-square.html
 * https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem
 *
 */
public class PerfectSquares {
    public static int numSquares(int n) {
        if (n <= 3)
            return n;

        // Create a dynamic programming table
        // to store sq
        int[] dp = new int[n + 1];

        // getMinSquares table for base case entries
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        // getMinSquares rest of the table using recursive
        // formula
        for (int i = 4; i <= n; i++) {
            // max value is i as i can always be represented
            // as 1*1 + 1*1 + ...
            dp[i] = i;

            // Go through all smaller numbers to
            // to recursively find minimum
            for (int x = 1; x <= Math.ceil(Math.sqrt(i)); x++) {
                int temp = x * x;
                if (temp > i)
                    break;
                else
                    dp[i] = Math.min(dp[i], 1 + dp[i - temp]);
            }
        }
        return dp[n];
    }

/*
Recursive solution
        int getMinSquares(int n)
        {
            // base cases
            if (n <= 3)
                return n;

            // getMinSquares rest of the table using recursive
            // formula
            int res = n; // Maximum squares required is
            // n (1*1 + 1*1 + ..)

            // Go through all smaller numbers
            // to recursively find minimum
            for (int x = 1; x <= n; x++) {
                int temp = x * x;
                if (temp > n)
                    break;
                else
                    res = Math.min(res, 1 + getMinSquares(n - temp));
            }
            return res;
        }
        public static void main(String args[])
        {
            System.out.println(getMinSquares(6));
        }

 */


    public static void main(String[] args) {
        System.out.println(numSquares(4));
    }
}
