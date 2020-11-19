package InterviewPractice.StringManipulation;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubsequence {
    public static String minWindow(String S, String T) {
        if(T.length()> S.length()) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : T.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int counter = map.size();

        int begin = 0, end = 0;
        int head = 0;
        int len = Integer.MAX_VALUE;

        while(end < S.length()){
            char c = S.charAt(end);
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }
            end++;

            while(counter == 0){
                char tempc = S.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        counter++;
                    }
                }
                if(end-begin < len){
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }

        }
        if(len == Integer.MAX_VALUE) return "";
        return S.substring(head, head+len);
    }

    public static void main(String[] args) {
    System.out.println(minWindow("abcdebdde","bde"));
    }
}
