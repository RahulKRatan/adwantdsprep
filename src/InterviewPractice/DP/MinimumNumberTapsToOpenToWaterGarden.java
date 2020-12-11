package InterviewPractice.DP;

import java.util.Arrays;

public class MinimumNumberTapsToOpenToWaterGarden {

    public static int minTaps(int n, int[] ranges) {
        // dp[i] is the min number of tapes to water area from 0 to i
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 2);// Initialize with max
        dp[0] = 0;// minimum tapes needed to water area 0 is 0(basically no area)
        for (int i = 0; i <= n; ++i)
            for (int j = Math.max(i - ranges[i] + 1, 0); j <= Math.min(i + ranges[i], n); ++j)
                dp[j] = Math.min(dp[j], dp[Math.max(0, i - ranges[i])] + 1);
        return dp[n]  < n + 2 ? dp[n] : -1;
    }

    public static void main(String[] args) {
        int[] ranges = new int[]{1,2,1,0,2,1,0,1};
        System.out.println(minTaps(7,ranges));
    }
}
