package Bootcamp.Arrays;

/**
 * Time complexity : O(n). Single pass.
 *
 * Space complexity : O(1). Constant space is used.
 * The intuition behind this approach is that the area formed between the lines will always be limited by the height
 * of the shorter line.
 * Further, the farther the lines, the more will be the area obtained.
 *
 * We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines.
 * Further, we maintain a variable maxarea to store the maximum area obtained till now.
 * At every step, we find out the area formed between them, update maxarea and move the pointer
 * pointing to the shorter line towards the other end by one step.
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxarea = 0, left = 0, right = height.length - 1;
        while (left < right) {
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
