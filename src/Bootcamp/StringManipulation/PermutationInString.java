package Bootcamp.StringManipulation;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()) return false;

        Map<Character,Integer> map=new HashMap<>();
        char[] chs1=s1.toCharArray();

        for(int i=0;i<chs1.length;i++){
            map.put(chs1[i],map.getOrDefault(chs1[i],0)+1);
        }

        int count=map.size();
        int start=0, end=0;
        int len=Integer.MAX_VALUE;

        while (end<s2.length()){
            char ech=s2.charAt(end);
            if (map.containsKey(ech)){
                map.put(ech,map.get(ech)-1);
                if (map.get(ech)==0) count--;
            }
            end++;
            while (count==0){
                char sch=s2.charAt(start);
                if (map.containsKey(sch)){
                    map.put(sch,map.get(sch)+1);
                    if (map.get(sch)>0) count++;
                }
                if(end-start==s1.length()) return true;
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaooo"));
    }
}
