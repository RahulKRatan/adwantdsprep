package Bootcamp.StringManipulation;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        if (s == null || s.isEmpty()) return 0;
        int left = 0, right = 0, counter = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < s.length()) {
            char ch = s.charAt(right++);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (counter < map.get(ch)) counter = map.get(ch);
            // check how many chars to "flip" by looking at the delta between the
            // length of the string and the highest frequency char. If <= k, no problem. Otherwise, move window
            while(!(right - left - counter <= k)) { // apply De Morgan and make it right - left - counter > k
                char tmp = s.charAt(left);
                map.put(tmp, map.get(tmp) - 1);
                counter = getMax(map);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
    private static int getMax(Map<Character, Integer> map) {
        int max = 0;
        for(int freq : map.values()) {
            max = Math.max(max, freq);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA",1));
    }
}
