package Bootcamp.Arrays;

/**
 * Time Complexity is O(n)
 * Space Complexity is O(n)
 *
 * Algorithm:
 * 1: With given towerHeight array, create 2 arrays, maxSeenRight and maxSeenLeft.
 *    maxSeenLeft[i]  - max height on left side of Tower[i].
 *    maxSeenRight[i] - max height on right side of Tower[i].
 * 2: Calculate for each tower:
 *    rainwater = rainwater + Max(Min(maxSeenLeft[i], maxSeenRight[i]) - towerHeight[i], 0);
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {

        int maxSeenSoFar = 0;
        int[] maxSeenRight = new int[height.length];
        int maxSeenLeft = 0;
        int rainwater = 0;

        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > maxSeenSoFar) {
                maxSeenSoFar = height[i];
                maxSeenRight[i] = maxSeenSoFar;
            } else {
                maxSeenRight[i] = maxSeenSoFar;
            }
        }

        for (int i = 0; i < height.length; i++) {
            rainwater = rainwater + Integer.max(Integer.min(maxSeenLeft, maxSeenRight[i]) - height[i], 0);
            if (height[i] > maxSeenLeft) {
                maxSeenLeft = height[i];
            }
        }

        return rainwater;
    }


}
