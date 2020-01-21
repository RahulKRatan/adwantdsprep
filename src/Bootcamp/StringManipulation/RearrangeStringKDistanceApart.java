package Bootcamp.StringManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class RearrangeStringKDistanceApart {

    public static String rearrangeString(String s, int k) {
        if(k==0)
            return s;

        //initialize the counter for each character
        final HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        //sort the chars by frequency
        PriorityQueue<Character> queue = new PriorityQueue<>((c1, c2) -> {
            if(map.get(c2).intValue()!=map.get(c1).intValue()){
                return map.get(c2)-map.get(c1);
            }else{
                return c1.compareTo(c2);
            }
        });


        for(char c: map.keySet())
            queue.offer(c);

        StringBuilder sb = new StringBuilder();
        int len = s.length();

        while(!queue.isEmpty()){
            int cnt = Math.min(k, len);
            ArrayList<Character> temp = new ArrayList<>();
            for(int i=0; i<cnt; i++){
                if(queue.isEmpty())
                    return "";
                char c = queue.poll();
                sb.append(String.valueOf(c));
                map.put(c, map.get(c)-1);
                if(map.get(c)>0){
                    temp.add(c);
                }
                len--;
            }
            for(char c: temp)
                queue.offer(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(rearrangeString("aaadbbcc",2));
    }
}
