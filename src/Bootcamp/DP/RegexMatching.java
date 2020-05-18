package Bootcamp.DP;


/**
 * Recursive formulation of DP
 *
 * DP How to process the '*'。
 *
 * dp[i][j] stands for whether s[0:i-1] matches p[0:j-1]
 *
 * Formula：Because only p will have regular expression，so we will analysis based on p.charAt(j - 1)
 *
 * p.charAt(j-1) != '.' && p.charAt(j-1) != '*'：dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1))
 *
 * p.charAt(j-1) == '.'：dp[i][j] = dp[i-1][j-1]
 *
 * The key point is when p.charAt(j-1) = '*'。Because '*' can match 0，1，or more p.charAt(j - 2)。
 *
 * 1. Match 0 element，remove p.charAt(j-2)，now p[0: j-1] = p[0: j-3]
 *
 * dp[i][j] = dp[i][j-2]
 *
 * 2. Match 1 element，here we have p[0: j-1] = p[0: j-2]
 *
 * dp[i][j] = dp[i][j-1]
 *
 * 3. Match 2+ elements，here p[0: j-1] = { p[0: j-2], p[j-2], ... , p[j-2] }
 *
 * dp[i][j] = dp[i-1][j] && (p[j-2]=='.' || s[i-2]==p[j-2])
 */
public class RegexMatching {

    public boolean matchRegexRecursive(char[] str, char[] pattern){
        return matchRegexRecursive(str,pattern,0,0);
    }

    private boolean matchRegexRecursive(char text[], char pattern[], int pos1, int pos2){
        //if pos2 has reached end of pattern means pos2 should also reach end of text for match
        //to happen
        if(pos2 == pattern.length) {
            return pos1 == text.length;
        }

        //if next character is not * means either current value at pattern and text should be same
        //or current value at pattern should be . in which case you can skip one character of text
        if(pos2 == pattern.length - 1 || pattern[pos2+1] != '*') {
            return (pos1 < text.length && (text[pos1] == pattern[pos2] || pattern[pos2] == '.')) && matchRegexRecursive(text, pattern, pos1+1, pos2+1);
        }

        //if we have case like abc and ad*bc so here we totally skip d*
        if(matchRegexRecursive(text, pattern, pos1, pos2+2)){
            return true;
        }

        //For case like abbc and ab*c match first b with b* and then next b to c. If that does not work out
        //then try next b with b* and then c with c and so on.
        //if pattern current val is . then skip one character at time from text till we either reach end of text
        //or a match is found
        while(pos1 < text.length && (text[pos1] == pattern[pos2] || pattern[pos2] == '.')){
            if( matchRegexRecursive(text, pattern, pos1+1, pos2+2)){
                return true;
            }
            pos1++;
        }
        return false;
    }

    /**
     * Dynamic programming technique for regex matching.
     */
    public boolean matchRegexDynamic(char[] text, char[] pattern) {
        boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];
    }

    public static void main(String[] args) {
        RegexMatching rm = new RegexMatching();
        System.out.println(rm.matchRegexDynamic("aaa".toCharArray(),"ab*a*c*a".toCharArray()));
    }
}
