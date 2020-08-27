package InterviewPractice.DP;


/**
 * https://youtu.be/K20Tx8cdwYY?t=1227
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubsetSum.java
 *
 * * Time complexity - O(input.size * total_sum)
 *  * Space complexity - O(input.size*total_sum)
 */
public class SubsetSum {

    public boolean subsetSum(int input[], int total) {

        boolean T[][] = new boolean[input.length + 1][total + 1];
        for (int i = 0; i <= input.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - input[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
        return T[input.length][total];

    }

    public boolean isSubsetSum(int set[],
                               int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        if (set[n-1] > sum)
            return isSubsetSum(set, n-1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return isSubsetSum(set, n-1, sum) ||
                isSubsetSum(set, n-1, sum-set[n-1]);
    }

    public static void main(String args[]) {
        SubsetSum ss = new SubsetSum();
        int arr1[] = {2, 3, 7, 8};
        System.out.println(ss.subsetSum(arr1, 11));
        System.out.println(ss.isSubsetSum(arr1,arr1.length,11));

    }
}
