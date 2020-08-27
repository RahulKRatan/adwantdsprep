package InterviewPractice.Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class NutsAndBolts {

    static String[] solve(int[] nuts, int[] bolts) {
        String[] strings = new String[nuts.length];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<nuts.length;i++){
        hashMap.put(i,nuts[i]);
        }
        for(int i=0;i<bolts.length;i++){
            if(hashMap.containsValue(bolts[i])){
                strings[i] = bolts[i] + " " + bolts[i];
            }
        }
        return strings;
    }

    static String[] solve2(int[] nuts, int[] bolts) {
        String[] strings = new String[nuts.length];
        Arrays.sort(nuts);
        Arrays.sort(bolts);
        for(int i=0;i<bolts.length;i++){
                strings[i] = nuts[i] + " " + bolts[i];
        }
        return strings;
    }

    public static void main(String[] args) {
        int[] nuts = new int[]{4, 32, 5, 7};
        int[] bolts = new int[]{32, 7, 5, 4};
        String[] result = solve2(nuts,bolts);
        for (int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
