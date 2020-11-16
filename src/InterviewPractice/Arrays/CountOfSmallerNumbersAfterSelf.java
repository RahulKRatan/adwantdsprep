package InterviewPractice.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Brute force method is O(N*N)
 * This is based on Inversion count algorithm
 * https://www.educative.io/edpresso/how-to-count-the-number-of-inversions-in-an-array
 * https://medium.com/@ssbothwell/counting-inversions-with-merge-sort-4d9910dc95f0
 * https://www.cp.eng.chula.ac.th/~prabhas//teaching/algo/algo2008/count-inv.htm
 *
 * The basic idea is to do merge sort to nums[]. To record the result,
 * we need to keep the index of each number in the original array.
 * So instead of sort the number in nums, we sort the indexes of each number.
 * Example: nums = [5,2,6,1], indexes = [0,1,2,3]
 * After sort: indexes = [3,1,0,2]
 *
 * While doing the merge part, say that we are merging left[] and right[], left[] and right[] are already sorted.
 * We keep a rightcount to record how many numbers from right[] we have added and keep an array count[] to record the result.
 * When we move a number from right[] into the new sorted array, we increase rightcount by 1.
 * When we move a number from left[] into the new sorted array, we increase count[ index of the number ] by rightcount.
  Time : O(NLOGN)
  Space : O(N)
 */
public class CountOfSmallerNumbersAfterSelf {
    static int[] count;

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int size = nums.length;
        count = new int[size];
        int[] indexes = new int[size];
        for(int i = 0; i < size; i++){
            indexes[i] = i; // indexes = [0,1,2,3]
        }
        mergesort(nums, indexes, 0, size - 1);
        for(int i = 0; i < size; i++){
            result.add(count[i]); // count = [2,1,1,0] && indexes = [3,1,0,2]
        }
        return result; // result = [2,1,1,0]
    }

    private static void mergesort(int[] nums, int[] indexes, int start, int end){
        if(end <= start){
            return;
        }
        int mid = (start + end) / 2;
        mergesort(nums, indexes, start, mid);
        mergesort(nums, indexes, mid + 1, end);

        merge(nums, indexes, start, end);
    }

    private static void merge(int[] nums, int[] indexes, int start, int end){
        int mid = (start + end) / 2;
        int leftIndex = start;
        int rightIndex = mid+1;
        int rightcount = 0;
        int[] newIndexes = new int[end - start + 1]; // temp index to track sorted indexes

        int sortIndex = 0;
        while(leftIndex <= mid && rightIndex <= end){
            if(nums[indexes[rightIndex]] < nums[indexes[leftIndex]]){
                newIndexes[sortIndex] = indexes[rightIndex];
                rightcount++;//When we move a number from right[] into the new sorted array, we increase rightcount by 1.
                rightIndex++;
            }else{
                newIndexes[sortIndex] = indexes[leftIndex];
                count[indexes[leftIndex]] += rightcount;//When we move a number from left[] into the new sorted array, we increase count[ index of the number ] by rightcount.
                leftIndex++;
            }
            sortIndex++;
        }
        while(leftIndex <= mid){
            newIndexes[sortIndex] = indexes[leftIndex];
            count[indexes[leftIndex]] += rightcount;
            leftIndex++;
            sortIndex++;
        }
        while(rightIndex <= end){
            newIndexes[sortIndex++] = indexes[rightIndex++];
        }
        for(int i = start; i <= end; i++){ // Important step to rearrange indexes
            indexes[i] = newIndexes[i - start];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,1};
        List<Integer> result = countSmaller(nums);
        System.out.println(result);
    }
}
