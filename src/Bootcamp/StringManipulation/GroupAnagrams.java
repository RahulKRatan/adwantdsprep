package Bootcamp.StringManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {


    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> temp = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(temp.containsKey(sorted)){
                List<String> abc = temp.get(sorted);
                abc.add(str);
                temp.put(sorted,abc);
            }
            else {
                List<String> cde = new ArrayList<>();
                cde.add(str);
                temp.put(sorted,cde);
            }

        }
        result.addAll(temp.values());
        return result;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strings);
    }
}
