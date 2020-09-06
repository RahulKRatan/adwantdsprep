package InterviewPractice.DP;

import java.time.Duration;
import java.time.Instant;

/**
 * Time -> 2 power n for recursive. and o(n) for DP and recur with memo
 */
public class ClimbingStairs {

    public static int climbStairsMemo(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public static int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }

    public static int climbStairsRecur(int n) {
        return climbStairs(0, n);
    }
    public static int climbStairs(int i,int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }

    // DP - valid solution
    public static int DPclimbStairs(int n) {
        if( n<=2) return n>0?n:0;
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for(int i=3;i<=n;i++){
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        System.out.println(climbStairsRecur(44));
        Instant end = Instant.now();
        System.out.println("Recursive duration: "+Duration.between(start, end).getNano());
        Instant start2 = Instant.now();
        System.out.println(DPclimbStairs(44));
        Instant end2 = Instant.now();
        System.out.println("DP duration: "+Duration.between(start2, end2).getNano());
        Instant start3 = Instant.now();
        System.out.println(climbStairsMemo(44));
        Instant end3 = Instant.now();
        System.out.println("DP duration: "+Duration.between(start3, end3).getNano());
    }
}
