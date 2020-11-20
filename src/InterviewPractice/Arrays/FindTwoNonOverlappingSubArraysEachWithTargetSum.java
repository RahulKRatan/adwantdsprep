package InterviewPractice.Arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindTwoNonOverlappingSubArraysEachWithTargetSum {
    public static int minSumOfLengths(int[] arr, int target) {
        int length = arr.length;
        int i=0;
        int j=0;
        int resultLength = 0;
        Queue<Integer> minHeap = new PriorityQueue<>();
        while(j<length){
            int tempSum = arr[j];
            while(tempSum < target && j<length-1){
                tempSum += arr[++j];
            }
            if(tempSum == target)
            {
            minHeap.add(j-i+1);
            j++;
            i=j;
            }
            if(tempSum > target) {
                i++;
                j=i;
            }
        }

        for(int k=0;k<2;k++){
            resultLength += minHeap.poll();
        }

        return resultLength == 0?-1:resultLength;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,6,2,3,4};
        System.out.println(minSumOfLengths(arr,3));
    }
}
