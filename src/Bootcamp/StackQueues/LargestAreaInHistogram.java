package Bootcamp.StackQueues;

import java.util.Stack;

/**
 * Time complexity : O(n). n numbers are pushed and popped.
 *
 * Space complexity : O(n). Stack is used.
 *
 * 1) Create an empty stack.
 *
 * 2) Start from first bar, and do following for every bar ‘hist[i]’ where ‘i’ varies from 0 to n-1.
 * ……a) If stack is empty or hist[i] is higher than the bar at top of stack, then push ‘i’ to stack.
 * ……b) If this bar is smaller than the top of stack, then keep removing the top of stack while top of the stack is greater. Let the removed bar be hist[tp]. Calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the ‘left index’ is previous (previous to tp) item in stack and ‘right index’ is ‘i’ (current index).
 *
 * 3) If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
 *
 */

public class LargestAreaInHistogram {
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= heights.length; i++) {
            int cur = (i == heights.length) ? -1 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] >= cur) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, h * w);
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] histogram = new int[]{2,1,5,6,2,3};
        System.out.println(largestRectangleArea(histogram));
    }
}
