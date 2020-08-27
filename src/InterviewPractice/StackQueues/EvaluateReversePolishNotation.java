package InterviewPractice.StackQueues;

import java.util.*;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        List<String> notations = new ArrayList<>();
        notations.add("+");notations.add("-");notations.add("*");notations.add("/");

        for(String s : tokens){
            if(notations.contains(s)){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                if(s.equals("+")){
                    stack.push(String.valueOf(a+b));
                }else if(s.equals("-")){
                    stack.push(String.valueOf(b-a));
                }else if(s.equals("*")){
                    stack.push(String.valueOf(a*b));
                }else {
                    stack.push(String.valueOf(b/a));
                }

                continue;
            }
            stack.push(s);
        }

        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }
}
