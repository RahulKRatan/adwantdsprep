package InterviewPractice.String;

import java.util.HashMap;
import java.util.Map;

/**
 * Greedy solution
 *
 * Time O(N): fill hash[] + find the letter + write results into char array
 * Space O(N + 26): result + hash[]
 *
 *We construct the resulting string in sequence: at position 0, 2, 4, ... and then 1, 3, 5, ...
 * In this way, we can make sure there is always a gap between the same characters
 *
 * Consider this example: "aaabbbcdd", we will construct the string in this way:
 *
 * a _ a _ a _ _ _ _ // fill in "a" at position 0, 2, 4
 * a b a _ a _ b _ b // fill in "b" at position 6, 8, 1
 * a b a c a _ b _ b // fill in "c" at position 3
 * a b a c a d b d b // fill in "d" at position 5, 7
 *
 */

public class ReorganizeString {

    public static String reorganizeString(String S) {
        if (S == null || S.length() == 1) return S;

        Map<Character, Integer> dic = new HashMap<>();
        char maxChar = S.charAt(0); // alphabet with max count
        int length = S.length();

        // count chars in map, get max
        for (char c: S.toCharArray()) {
            dic.put(c, dic.getOrDefault(c, 0) +1);
            if (dic.get(c) > dic.get(maxChar)) {
                maxChar = c;
            }
        }

        //if maxchar count is more than half the string size then we return ""
        if (dic.get(maxChar) > (length+1)/2) return "";

        int idx = 0;
        char[] result = new char[length];

        // put all maxChar's into array (may not reach end of S)
        while (idx < length && dic.get(maxChar) > 0) {
            result[idx] = maxChar;
            dic.put(maxChar, dic.get(maxChar)-1);
            idx +=2;
        }

        // loop through dic, may go through a key where val is 0, but won't do anything
        for (Character c: dic.keySet()) {
            while (dic.get(c) > 0) {
                if (idx >= length) idx = 1; // First time it reaches L, reset it. Won't be inf loop cause not looping on idx
                result[idx] = c;
                dic.put(c, dic.get(c)-1);
                idx += 2;
            }
        }
        return new String(result);
    }


    public static void main(String[] args) {
        String S = "aab";
        System.out.println(reorganizeString(S));
    }
}
