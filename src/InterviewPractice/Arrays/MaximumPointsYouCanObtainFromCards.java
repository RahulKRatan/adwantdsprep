package InterviewPractice.Arrays;

/**
 * Find cumulative sum from beginning to the current index.
 * Find cumulative sum from behind till the current index.
 * If you choose i elements from front, you will need to choose k-i elements from behind.
 * Sum of first i elements = cumulativeSumFromFront[i],
 * Sum of last (k-i) elements = cumulativeSumFromBehind[K-i].
 * So points obtained when choosing i elements from the front = cumulativeSumFromFront[i] + cumulativeSumFromBehind[K-i]
 * Repeat Step 3 for all i ranging from 0 to K.
 * Return the maximum value of points reached.
 *
 * Time : O(N)
 * Space : O(1)
 *
 */
public class MaximumPointsYouCanObtainFromCards {
    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int sum = 0;
        for(int i=0; i<k; i++){
            sum+=cardPoints[i];
        }
        int max = sum;
        for(int i=0; i<k; i++){
            sum = sum - cardPoints[k-i-1] + cardPoints[n-i-1]; // adding right most and removing leftmost of k
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] cardPoints = new int[]{1,2,3,4,5,6,1};
        System.out.println(maxScore(cardPoints,3));
    }
}
