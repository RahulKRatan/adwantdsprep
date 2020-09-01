package InterviewPractice.Arrays;

/**
 * Time complexity : O(n+m).
 * Space complexity : O(1).
 */
public class MergeTwoSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i=m-1;
        int j=n-1;
        int k=nums1.length-1;
        while(i >= 0 && j>= 0){
            if(nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }
            else{
                nums1[k--] = nums2[j--];
            }
        }
        while(j >= 0){
            nums1[k--]=nums2[j--];
        }

    }

    public static void main(String[] args) {
        int[] num2 = new int[]{1,3,5};
        int[] num1 = new int[]{2,4,6,0,0,0};
        merge(num1,3,num2,3);
    }
}
