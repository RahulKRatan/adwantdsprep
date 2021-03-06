package InterviewPractice.Arrays;

public class FibonacciNumber {
    public static int fib(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<=N;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
