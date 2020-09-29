package InterviewPractice.StringManipulation;

import java.util.Stack;

public class DecodeString {

    public static String decodeString(String s) {
        String res = ""; // final result
        Stack<Integer> countStack = new Stack<>(); // num of times to iterate
        Stack<String> resStack = new Stack<>(); // resStack will always have recent calculated result
        int index = 0;
        while (index < s.length()) {

            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            }

            else if (s.charAt(index) == '[') {
                resStack.push(res); // pushing previous calculated result
                res = "";
                index++;
            }

            else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            }

            else {
                res += s.charAt(index++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
