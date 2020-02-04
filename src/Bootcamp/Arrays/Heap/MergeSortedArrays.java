package Bootcamp.Arrays.Heap;

import java.util.*;

public class MergeSortedArrays {

    static int[] mergeArrays(int[][] arr){
        List<Iterator<Integer>> lists = new ArrayList<>(arr.length);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            List<Integer> intList = new ArrayList<>();
            for(int y=0;y<arr[i].length;y++)
            {
                intList.add(arr[i][y]);
            }
            lists.add(intList.iterator());
        }
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(arr.length, Comparator.comparingInt(s -> s.value));
        for(int i=0;i<lists.size();i++){
            minHeap.add(new ArrayEntry(lists.get(i).next(),i));
        }

        while (!minHeap.isEmpty()){
            ArrayEntry arrayEntry = minHeap.poll();
            res.add(arrayEntry.value);
            int id = arrayEntry.arrayId;
            if(lists.get(id).hasNext()){
                minHeap.add(new ArrayEntry(lists.get(id).next(),id));
            }
        }
        int ans[] = new int[res.size()];
        int pointer = 0;
        for(int j=0;j<res.size();j++){
            ans[pointer++] = res.get(j);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] values = new int[][]{{433},{264},{388723,387333,386888,386563,385325,383848}};
        int[] result = mergeArrays(values);
        for(int j=0;j<result.length;j++){
            System.out.println(result[j]);
        }
    }
}

class ArrayEntry{
    public Integer value;
    public Integer arrayId;

    public ArrayEntry(Integer value, Integer arrayId) {
        this.value = value;
        this.arrayId = arrayId;
    }
}
