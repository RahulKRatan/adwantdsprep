package InterviewPractice.String;

import java.util.ArrayList;
import java.util.List;

/**
 * We only need to check for two things:
 *
 * If we see '//' we stop reading the current line, and add whatever characters we have seen to the result.
 * If we see '/*' then we start the multiline comment mode and we keep on ignoring characters until we see "*'/"
 * If the current character is neither of the above two and the multiline comment mode is off, then we add that character to the current line.
 *
 * Once we parse one line (source[i]), then if the mode is off, we add the currently generated line (StringBuilder) to the result and repeat for source[i + 1].
 * We need to be careful not to insert empty lines in the result.
 * Time Complexity: O(S), where S is the total length of the source code.
 * Space Complexity: O(S), the space used by recording the source code into ans.
 */
public class RemoveComments {

    public static List<String> removeComments(String[] source) {
        List<String> result  = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean multiLineMode = false; // multi line comment multiLineMode

        for (String s : source) {

            for (int i = 0; i < s.length(); i++) {
                if (multiLineMode) {
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        multiLineMode = false;
                        i++;        //skip '/' on next iteration of i
                    }
                }
                else {
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break;      //ignore remaining characters on line s
                    }
                    else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        multiLineMode = true;
                        i++;           //skip '*' on next iteration of i
                    }
                    else    sb.append(s.charAt(i));     //not a comment
                }
            }

            if (!multiLineMode && sb.length() > 0) {
                result.add(sb.toString());
                sb = new StringBuilder();   //reset for next line of source code
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] source = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        List<String> result = removeComments(source);
        System.out.println(removeComments(source));
    }
}
