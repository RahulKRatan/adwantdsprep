package Bootcamp.StackQueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        List<String> notations = new ArrayList<>();
        notations.add("+");notations.add("-");notations.add("*");notations.add("/");

        for(String s : tokens){
            if(notations.contains(s)){
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                if(s == "+"){
                    stack.push(String.valueOf(a+b));
                }else if(s == "-"){
                    stack.push(String.valueOf(b-a));
                }else if(s == "*"){
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
