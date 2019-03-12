package Bootcamp.Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    static String[] generate_all_subsets(String s) {
        List<String> list = new ArrayList<>();
        return subset("",s,list);
    }
    static String[] subset(String prefix, String s, List<String> list){
        list.add(prefix);
        for(int i=0;i<s.length();i++){
            subset(prefix + s.charAt(i), s.substring(i + 1),list);
        }
        return list.toArray(new String[0]);
    }
    public static void main(String[] args) {
        String s = "abc";
        String[] result = generate_all_subsets(s);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
