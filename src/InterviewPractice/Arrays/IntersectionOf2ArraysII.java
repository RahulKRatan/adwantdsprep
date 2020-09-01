package InterviewPractice.Arrays;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Time Complexity: O(n+m), where nn and mm are the lengths of the arrays.
 * We iterate through the first, and then through the second array; insert and lookup operations in the hash map take a constant time.
 *
 * Space Complexity: O(min(n,m)). We use hash map to store numbers (and their counts) from the smaller array.
 */
public class IntersectionOf2ArraysII {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums1){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i: nums2){
            if(map.containsKey(i)){
                if(map.get(i)>1){
                    map.put(i, map.get(i)-1);
                }else{
                    map.remove(i);
                }
                list.add(i);
            }
        }

        int[] result = new int[list.size()];
        int i =0;
        while(i<list.size()){
            result[i]=list.get(i);
            i++;
        }

        return result;
    }


    public static void main(String[] args) {
        int[] first = new int[]{1,2,2,1};
        int[] second = new int[]{2,2};
        System.out.print(intersection(first,second));
    }

}
