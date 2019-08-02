package Bootcamp.StringManipulation;

import java.util.HashMap;

public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        paragraph = paragraph.replaceAll("\\p{Punct}","");
        String[] input = paragraph.trim().split(" ");


        return "";
    }


    public static void main(String[] args) {
        String paragrah = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        System.out.println(mostCommonWord(paragrah,banned));
    }
}
