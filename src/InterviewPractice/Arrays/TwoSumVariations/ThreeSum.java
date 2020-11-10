package InterviewPractice.Arrays.TwoSumVariations;

import java.util.Arrays;
import java.util.TreeSet;

public class ThreeSum {

    static String[] threeSum(int[] arr){
        TreeSet<String> set = new TreeSet<>();
        Arrays.sort(arr);
        int size = arr.length;
        for(int i=0;i<size-2;i++){
            int l = i+1,r =size-1;
        while(l<r){
            if (arr[i] + arr[l]+arr[r] == 0) {
                if(!set.contains(arr[i]+","+arr[l]+","+arr[r])){
                    set.add(arr[i]+","+arr[l]+","+arr[r]);
                }
                l++;
            }
            if(arr[i] + arr[l]+arr[r] < 0){
                l++;
            }
            else {
                r--;
            }
        }
        }
        return set.toArray(new String[set.size()]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 3, -4, 1, -6, 9};
        String[] result = threeSum(arr);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
