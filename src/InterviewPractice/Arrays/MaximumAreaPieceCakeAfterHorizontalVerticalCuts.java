package InterviewPractice.Arrays;

import java.util.Arrays;

/**
 * Key idea:
 * If we need the area, we must think of lengths and breadths of each cake piece.
 *
 * Assume
 * LENGTH as total horizontal length of the original cake.
 * HEIGHT as total vertical height of the original cake.
 * H as number of horizontal cuts. HCUTS is array of horizontal cuts.
 * Similarly, V as number of vertical cuts and VCUTS is an array of vertical cuts.
 *
 * Solution
 *
 * Lets only think of horizontal cuts. Each HCUTS[i] would create a piece with length LENGTH and height, say, heights[i].
 * As there are H cuts, there will be (H+1) pieces of length LENGTH.
 *
 * Now each vertical cut VCUTS[i] will cut each of the horizontal pieces that we got in step 1.
 * We already know the height of each piece (step 1), now with each vertical cut, we will know the length of each piece as well.
 *
 * Because we want the maximize the area, we must try to maximize the length and height of each piece.
 *
 * Algorithm
 *
 * Find heights of pieces if we only perform the horizontal cuts. Say this array is heights[].
 * Find lengths of pieces if we only perform the vertical cuts. Say this arrays is lengths[].
 * Find max of heights[] and lengths[].
 * Multiply those two max and take mod 10e7.
 * Return the answer
 *
 * Complexity Analysis
 *
 * Time: O(vlogv + hlogh), where v and h are the number of vertical and horizontal cuts.
 * Memory: O(1), plus memory required by the sort algorithm (from O(log n) to O(n), where n is the number of elements we sort).
 */
public class MaximumAreaPieceCakeAfterHorizontalVerticalCuts {

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxH = 0;
        int maxV = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0; i < horizontalCuts.length; i++) {
            maxH = Math.max(maxH, i == 0 ? horizontalCuts[i] : horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxH = Math.max(maxH, h - horizontalCuts[horizontalCuts.length - 1]);
        for (int i = 0; i < verticalCuts.length; i++) {
            maxV = Math.max(maxV, i == 0 ? verticalCuts[i] : verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxV = Math.max(maxV, w - verticalCuts[verticalCuts.length - 1]);
        return (int)(maxH % (1e9 + 7) * maxV % (1e9 + 7)); //Since the answer can be a huge number, return this modulo 10^9 + 7 -> given in the question statement
    }

    public static void main(String[] args) {
        System.out.println(maxArea(5,4,new int[]{1,2,4}, new int[]{1,3}));
    }
}
