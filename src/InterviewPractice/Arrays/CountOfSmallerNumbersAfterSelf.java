package InterviewPractice.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
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
            result.add(count[i]); // count = [2,1,1,0]
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
        int left_index = start;
        int right_index = mid+1;
        int rightcount = 0;
        int[] new_indexes = new int[end - start + 1];

        int sort_index = 0;
        while(left_index <= mid && right_index <= end){
            if(nums[indexes[right_index]] < nums[indexes[left_index]]){
                new_indexes[sort_index] = indexes[right_index];
                rightcount++;
                right_index++;
            }else{
                new_indexes[sort_index] = indexes[left_index];
                count[indexes[left_index]] += rightcount;
                left_index++;
            }
            sort_index++;
        }
        while(left_index <= mid){
            new_indexes[sort_index] = indexes[left_index];
            count[indexes[left_index]] += rightcount;
            left_index++;
            sort_index++;
        }
        while(right_index <= end){
            new_indexes[sort_index++] = indexes[right_index++];
        }
        for(int i = start; i <= end; i++){
            indexes[i] = new_indexes[i - start];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,6,1};
        List<Integer> result = countSmaller(nums);
        System.out.println(result);
    }
}
