package InterviewPractice.Design;

import java.util.Stack;

/**
 * A regular stack already supports the first 3 operations, so we focus on the last two.
 *
 * For peekMax, we remember the largest value we've seen on the side.
 * For example if we add [2, 1, 5, 3, 9], we'll remember [2, 2, 5, 5, 9]. This works seamlessly with pop operations,
 * and also it's easy to compute: it's just the maximum of the element we are adding and the previous maximum.
 *
 * For popMax, we know what the current maximum (peekMax) is. We can pop until we find that maximum, then push the popped elements back on the stack.
 *
 * Time Complexity: O(N) for the popMax operation, and O(1) for the other operations, where NN is the number of operations performed.
 *
 * Space Complexity: O(N), the maximum size of the stack.
 *
 *
 */

public class MaxStack {
    static Stack<Integer> stack;
    static Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public static void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(max > x ? max : x);
        stack.push(x);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while (top() != max) buffer.push(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pop());
        return max;
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(5);
    }

}
