package Bootcamp.Arrays;


/*
Algorithm :
Multiply from left
Multiply from right
update cell left * right
https://www.youtube.com/watch?v=vB-81TB6GUc
 */

public class ProductArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        productExceptSelf(nums);
    }
}
