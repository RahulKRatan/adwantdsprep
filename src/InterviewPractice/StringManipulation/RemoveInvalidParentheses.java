package InterviewPractice.StringManipulation;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {

    /*
        DFS Solution
        We all know how to check a string of parentheses is valid using a stack. Or even simpler use a counter.
The counter will increase when it is ‘(‘ and decrease when it is ‘)’. Whenever the counter is negative, we have more ‘)’ than ‘(‘ in the prefix.

To make the prefix valid, we need to remove a ‘)’. The problem is: which one? The answer is any one in the prefix.
However, if we remove any one, we will generate duplicate results, for example: s = ()), we can remove s[1] or s[2] but the result is the same ().
Thus, we restrict ourself to remove the first ) in a series of concecutive )s.

After the removal, the prefix is then valid. We then call the function recursively to solve the rest of the string.
However, we need to keep another information: the last removal position. If we do not have this position, we will generate duplicate by removing two ‘)’ in two steps only with a different order.
For this, we keep tracking the last removal position and only remove ‘)’ after that.

Now one may ask. What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘?
The answer is: do the same from right to left.
However a cleverer idea is: reverse the string and reuse the code!
Here is the final implement in Java.

     */
    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        char[] check = new char[]{'(', ')'};
        dfs(s, res, check, 0, 0);
        return res;
    }

    public static void dfs(String s, List<String> res, char[] check, int iStart, int jStart) {
        int count = 0;
        int i = iStart;
        while (i < s.length() && count >= 0) {

            if (s.charAt(i) == check[0]) count++;
            if (s.charAt(i) == check[1]) count--;
            i++;
        }

        if (count >= 0) {
            // no extra ')' is detected. We now have to detect extra '(' by reversing the string.
            String reversed = new StringBuffer(s).reverse().toString();
            if (check[0] == '(') dfs(reversed, res, new char[]{')', '('}, 0, 0);
            else res.add(reversed);

        } else {  // extra ')' is detected and we have to do something
            i -= 1; // 'i-1' is the index of abnormal ')' which makes count<0
            for (int j = jStart; j <= i; j++) { //jStart = j prevents duplicates
                if (s.charAt(j) == check[1] && (j == jStart || s.charAt(j - 1) != check[1])) {
                    dfs(s.substring(0, j) + s.substring(j + 1), res, check, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        String string = "()())()";
        System.out.println(removeInvalidParentheses(string));
    }


}
