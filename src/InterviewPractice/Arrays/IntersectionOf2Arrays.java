package InterviewPractice.Arrays;

import java.util.ArrayList;
import java.util.HashSet;


public class IntersectionOf2Arrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        HashSet<Integer> intersection = new HashSet<>();

        for (int i : nums1) {
            intersection.add(i); // 4,7,9,6
        }
        for (int j : nums2){
            if(intersection.contains(j)){
                res.add(j);
                intersection.remove(j);
            }
        }
        int[] arr = new int[res.size()];
        for (int i= 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
    }


    public static void main(String[] args) {
        int[] first = new int[]{1,2,2,1};
        int[] second = new int[]{2,2};
        System.out.print(intersection(first,second));
    }

}
