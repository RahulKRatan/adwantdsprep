package Bootcamp.Arrays;

import java.util.Arrays;
import java.util.TreeSet;

public class TopK {

    static int[] topK(int[] arr, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0;i<arr.length;i++){
            treeSet.add(arr[i]);
            if(treeSet.size() > k){
                treeSet.pollFirst();
            }
        }
        int ans[] = new int[treeSet.size()];
        int pointer = 0;
        while(treeSet.iterator().hasNext()){
            ans[pointer++] = treeSet.pollFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 1, 5, 1};
        int k = 3;
        int[] result = topK(arr,k);
        Arrays.stream(result).forEach(s-> System.out.println(s));
    }
}
