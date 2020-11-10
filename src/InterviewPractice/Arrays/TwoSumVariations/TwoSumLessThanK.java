package InterviewPractice.Arrays.TwoSumVariations;

import java.util.Arrays;

public class TwoSumLessThanK {

    public static int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        int result = Integer.MIN_VALUE;
        while(l<r){
            if(A[l]+A[r] < K){
                result = Math.max(result,A[l]+A[r]);
                l++;
            }else{
                r--;
            }
        }
        return result == Integer.MIN_VALUE? -1: result;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{34,23,1,24,75,33,54,8};
        System.out.println(twoSumLessThanK(numbers,60));
    }
}
