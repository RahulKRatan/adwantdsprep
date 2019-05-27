package Bootcamp.StringManipulation.Anagram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllAnagramsString {

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int i=0,j=p.length()-1;
        int size = s.length()-1;
        if(p.length() > size){
            return result;
        }
        while (j <=size ){
            if(containsAllChars(s.substring(i,j+1),p)){
                result.add(i);
                i = i+1;
                j = j+1;
            }
            else {
                i = i+1;
                j = j+1;
            }
        }
        return result;
    }

    public static boolean containsAllChars
            (String container, String containee) {
        return stringToCharacterSet(container).containsAll
                (stringToCharacterSet(containee));
    }

    public static Set<Character> stringToCharacterSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    public static void main(String[] args) {
        List<Integer> res = findAnagrams("baa","aa");
        System.out.println(res);
    }
}
