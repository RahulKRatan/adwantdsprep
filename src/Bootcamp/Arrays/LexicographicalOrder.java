package Bootcamp.Arrays;


import java.util.HashMap;

public class LexicographicalOrder {

    static String[] solve(String[] arr) {
        HashMap<String,Integer> counter = new HashMap<>();
        HashMap<String,String> max = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            String[] temp= arr[i].split(" ");
            String key = temp[0];
            String value = temp[1];
            counter.put(key,counter.get(key) == null ? 1 : counter.get(key) + 1);
            if(max.containsKey(key)){ // messed this up
                String value1 = max.get(key);
                String value2 = value;
                if(value1.compareTo(value2)<0){
                    max.put(key,value2);
                }else {
                    max.put(key,value1);
                }
            }else {
                max.put(key,value);
            }

        }
        String answer[] = new String[counter.size()];
        int pointer = 0;
        for (String key : counter.keySet()) {
            answer[pointer++] = key + ":" + counter.get(key) + "," + max.get(key);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"mark zuckerberg","tim cook","mark twain"};
        String[] result = solve(input);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}

//tim:1,cook
//mark:2,zuckerberg