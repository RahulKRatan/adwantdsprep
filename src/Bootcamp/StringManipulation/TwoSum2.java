package Bootcamp.StringManipulation;

import java.util.HashMap;

public class TwoSum2 {
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> res = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<numbers.length;i++){
            if(res.containsValue(numbers[i])){
                result[0] = res.get(numbers[i]);
                result[1] = i;
            }
            else {
                res.put(i,target - numbers[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
            int[] numbers = new int[]{2,7,11,15};
            twoSum(numbers,9);
    }


}
