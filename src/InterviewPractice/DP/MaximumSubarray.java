package InterviewPractice.DP;

/**
 * https://www.youtube.com/watch?v=86CQq3pKSUw&ab_channel=CSDojo
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] array) {
        int currentMax = array[0];
        int totalMax =  array[0];

        for(int i = 1; i < array.length; i++){
            currentMax = Math.max(currentMax+array[i], array[i]);
            totalMax = Math.max(totalMax, currentMax);
        }
        return totalMax;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}

/*
Time Complexity: O(N)
Space Complexity: O(N)

public int Kadanes(int[] array){
    int n = array.length;
    int[] dp = new int[n];

    //base condition
    dp[0] = array[0];

    int answer = Integer.MIN_VALUE;
    for(int i = 1; i < n; i++){
        dp[i] = Math.max(dp[i - 1], 0) + array[i];
        answer = Math.max(answer, dp[i]);
    }
    return answer;
}
 */