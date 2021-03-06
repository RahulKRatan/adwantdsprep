package InterviewPractice.Arrays;

/**
 * T : O(N)
 * S : O(1)
 *
 * Explanation:
 * We can move a chip at any position to 2 positions left or 2 positions right at no cost at all.
 * So we can keep moving all chips at positions of even numbers to position 2 at no cost, and all chips at odd positions to position 1 at no cost.
 * Now, we have x chips at position 1 and y chips at position 2. If x > y, then move all y chips by 1 unit to the right to be at position 2,
 * and return y. But if y > x, then move all x chips by 1 unit to the left to be at position 1, and return x.
 *
 * Essentially, we're counting how many odd numbers and even numbers there are and returning the smaller count.
 * chips = [1,2,3]. 2 odd numbers and 1 even number. Return 1.
 * chips = [2,2,2,3,3]. 2 odd numbers and 3 even numbers. Return 2.
 * chips = [1,3,5,7,9,11,2,4]. 6 odd numbers and 2 even numbers. Return 2.
 *
 */


public class MinimumCostMoveChipsTheSamePosition {

    public static int minCostToMoveChips(int[] position) {
        int evenPosition = 0;
        int oddPosition = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                evenPosition++;
            } else {
                oddPosition++;
            }
        }
        return Math.min(oddPosition, evenPosition);
    }

    public static void main(String[] args) {
        int[] positions = new int[]{2,2,2,3,3};
        System.out.println(minCostToMoveChips(positions));
    }
}
