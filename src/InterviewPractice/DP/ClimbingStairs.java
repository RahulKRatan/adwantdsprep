package InterviewPractice.DP;

public class ClimbingStairs {

    // Recursive - TLE error
    public static int climbStairs(int n) {
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        return climbStairs(n-1) + climbStairs(n-2);
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

    /*
    Memoization
     public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    public int climb_Stairs(int i, int n, int memo[]) {
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
     */

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
        System.out.println(DPclimbStairs(44));
    }
}
