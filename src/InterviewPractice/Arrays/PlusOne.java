package InterviewPractice.Arrays;


/**
 * The last part of code is only for the case that the whole input array is 9s.
 * For example : 99999-----> 100000
 * Any other case would return in the loop.
 * https://leetcode.com/problems/plus-one/discuss/24082/My-Simple-Java-Solution
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits; // return if any digit is not 9. If all are 9's then it goes to last return
            }
            digits[i] = 0;
        }

        int[] firstNumber = new int [n+1];
        firstNumber[0] = 1;
        return firstNumber;  // edge case if all digits are 9's.
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{4,9,9};
        System.out.println(plusOne(numbers));
    }
}
