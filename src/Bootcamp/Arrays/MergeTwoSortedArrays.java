package Bootcamp.Arrays;

public class MergeTwoSortedArrays {

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;
        while(p1 >= 0 && p2 >= 0){
            nums1[p--] = ( nums1[p1]<nums2[p2] ) ? nums2[p2--]:nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        return nums1;
    }

    public static void main(String[] args) {
        int[] num2 = new int[]{1,3,5};
        int[] num1 = new int[]{2,4,6,0,0,0};
        int[] result = merge(num1,3,num2,3);
        System.out.println(result);
    }
}
