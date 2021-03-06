package InterviewPractice.StackQueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time Complexity: O(N), where N is the length of pushed and popped.
 *
 * Space Complexity: O(N).
 */
public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int length = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == length;
    }
    public static void main(String[] args) {
        int[] pushed = new int[]{1,2,3,4,5};
        int[] popped = new int[]{4,5,3,2,1};
        System.out.println(validateStackSequences(pushed,popped));
    }
}
