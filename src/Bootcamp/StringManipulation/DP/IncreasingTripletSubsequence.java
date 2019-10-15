package Bootcamp.StringManipulation.DP;

/**
 * Starting from left to right, the numbers could lie in range [-----] for any small<big<thirdvalue
 * -----small< -----big< -----thirdvalue
 *
 * a) if currentelement is less than small : update small to currentelement now the range for big can expand between new small and big
 * b) if currentelement is between small and big and less than current big : update big to currentelement now the range for thirdvalue can be any number greater than big
 * c) if currentelement is greater than big: we found 3 such values return true
 *
 * patience sorting = see also longest increasing subsequence
 *
 */
public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,1,1,1,1,1,1};
        System.out.println(increasingTriplet(ints));
    }
}
