package Bootcamp.Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Time complexity : O(Nlogk).
Space complexity : O(k) to store the heap elements.

Store elements in map heap and then poll upto k-1. return heap.poll()

Hoare's selection algorithm - try this out
*/

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        //decreasing order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num: nums){
            maxHeap.add(num);
        }
        for(int i=0;i<k-1;i++){
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,3));
    }
}
