package InterviewPractice.StackQueues;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Principle:
 *
 * (Sign before '+'/'-') = (This context sign);
 * (Sign after '+'/'-') = (This context sign) * (1 or -1);
 * Algorithm:
 *
 * Start from +1 sign and scan s from left to right;
 * if c == digit: This number = Last digit * 10 + This digit;
 * if c == '+': Add num to result before this sign; This sign = Last context sign * 1; clear num;
 * if c == '-': Add num to result before this sign; This sign = Last context sign * -1; clear num;
 * if c == '(': Push this context sign to stack;
 * if c == ')': Pop this context and we come back to last context;
 * Add the last num. This is because we only add number after '+' / '-'.
 *
 * https://leetcode.com/problems/basic-calculator/discuss/62361/Iterative-Java-solution-with-stack -> in comments
 */
public class BasicCalculator {
    public static int calculate(String s) {
        if(s == null) return 0;

        int result = 0;
        int sign = 1;
        int num = 0;

        Deque<Integer> stack = new LinkedList<>(); //Use stack to save signs.
        stack.push(sign);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                num = num * 10 + (c - '0'); //in case if we have more than one digit for the number. ex: "12", so we will break it down to 1 * 10 + 2 = 12
            } else if(c == '+' || c == '-') {
                result += sign * num;
                sign = stack.peek() * (c == '+' ? 1: -1);
                num = 0;
            } else if(c == '(') {
                stack.push(sign);
            } else if(c == ')') {
                stack.pop();
            }
        }

        result += sign * num; //Add the last num. This is because we only add number after '+' / '-'
        return result;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
}
