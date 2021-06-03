package InterviewPractice.StackQueues;

import java.util.Stack;

/*
so basically,

1 stack to save the numbers
1 buffer for number(cos it might have more than one digit)
1 buffer for operand
if the current character is a digit, sum up with the previous digit e.g. "23" -> 2*10+3
if the current character is an operand + - * /
1. operate the number with the previous operand
        2. and put the result into the stack
        3. set the current character as the next operand
        sum up all the numbers in the stack to get the result
        i hope it helps!
 */
public class BasicCalculatorII {
    public static int calculate(String s) {
        if(s==null || s.length()==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        int len=s.length();
        for(int i=0;i<len;i++){

            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0'; //in case if we have more than one digit for the number. ex: "12", so we will break it down to 1 * 10 + 2 = 12
            }

            if((!Character.isDigit(s.charAt(i)) && ' '!=s.charAt(i)) || i==len-1){ //Cause at last loop, it only get the number but not added to the final result. By adding ||i==len-1, it will enter the loop and added number to final result.
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }

        }

        int result = 0;
        for(int i:stack){
            result += i;
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }
}
