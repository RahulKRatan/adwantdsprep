package Bootcamp.StringManipulation;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int counter = 0;
        // Array to save the character of the target substring  <Character, Frequency>
        int[] map = new int[256];
        for (char c : t.toCharArray()) {
            if (map[c]++ == 0)
                counter++;
        }

        int begin = 0, end = 0, head = 0;
        int len = Integer.MAX_VALUE;

        while(end < s.length()) {
            char c = s.charAt(end++);
            if (--map[c] == 0)  counter--;

            while (counter == 0) {
                char tmp = s.charAt(begin);
                if (++map[tmp] > 0)  counter++;
                if (end - begin < len) {
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }
        }
        return (len == Integer.MAX_VALUE)? "" : s.substring(head, head + len);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }
}
