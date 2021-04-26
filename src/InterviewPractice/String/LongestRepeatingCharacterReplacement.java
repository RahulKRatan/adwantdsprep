package InterviewPractice.String;

import java.util.HashMap;
import java.util.Map;

/**
 * explanation : https://www.youtube.com/watch?v=00FmUN1pkGE
 */
public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) return 0;
        int left = 0, right = 0, counter = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (counter < map.get(ch)) counter = map.get(ch);
            // check how many chars to "flip" by looking at the delta between the
            // length of the string and the highest frequency char. If <= k, no problem. Otherwise, move window
            // apply De Morgan and make it right - left - counter > k
            while (right - left - counter + 1 > k) { // number of different elements other than counter element should not exceed k
                char tmp = s.charAt(left);
                map.put(tmp, map.get(tmp) - 1);
                left++;
            }
            res = Math.max(res, right - left);
            right++;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",1));
    }
}
