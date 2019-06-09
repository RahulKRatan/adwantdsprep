package Bootcamp.Design;

import java.util.Stack;

/**
 * Core Idea:
 * 1.Minimum value is always followed by the second minimum value
 * (duplicate value of the second minimum value, to ensure that when pop function removes the 2nd min,
 * it does not disrupt the stack order).
 * 2.And while popping you pop min and 2nd min so that,
 * you get the correct min value for the remaining stack and the remaining stack top also points to the right place.
 */

public class MinStack {

    static int min = Integer.MAX_VALUE;
    static Stack<Integer> stack = new Stack<Integer>();
    public static void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public static void pop() {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public static int top() {
        return stack.peek();
    }

    public static int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
