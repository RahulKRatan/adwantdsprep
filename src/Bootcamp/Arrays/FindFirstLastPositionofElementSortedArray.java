package Bootcamp.Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FindFirstLastPositionofElementSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        List<Integer> count = new ArrayList<>();
        int start = 0;
        int end = nums.length-1;
        while (start<end){
            int mid = (start+end)/2;
            if(target == nums[mid]){
                count.add(mid);
                if(mid < nums.length-1 && nums[mid+1] == target){
                    for(int i=mid+1;i<nums.length;i++){
                        if(nums[i] == target){
                            count.add(i);
                        }
                    }
                }
                if(mid > 0 && nums[mid-1] == target){
                    for(int i=mid-1;i>=0;i--){
                        if(nums[i] == target){
                            count.add(i);
                        }
                    }
                }
            }

            if( target < nums[mid]){
                end = mid -1;
            }
            else {
                start = mid + 1;
            }
        }

        int[] ret = new int[count.size()];
        Iterator<Integer> iter = count.iterator();
        for (int i=0; iter.hasNext(); i++) {
            ret[i] = iter.next();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] result = searchRange(nums,8);
        for (int res: result) {
            System.out.println(res);
        }
    }
}
