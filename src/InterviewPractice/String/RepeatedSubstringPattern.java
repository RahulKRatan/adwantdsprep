package InterviewPractice.String;


/**
 * The length of the repeating substring must be a divisor of the length of the input string
 * Search for all possible divisor of str.length, starting for length/2
 * If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
 * If the repeated substring is equals to the input str return true
 */

public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String str) {
        int l = str.length();
        for(int i=l/2;i>=1;i--) {
            if(l%i==0) {
                int m = l/i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++) {
                    sb.append(subS);
                }
                if(sb.toString().equals(str)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abcabcabc"));
    }
}
