package InterviewPractice.StringManipulation.Palindrome;

/**
 * We can solve this problem by finding the position of mismatch.
 * We start looping in the string by keeping two pointers at both the ends which traverse towards mid position after each iteration,
 * this iteration will stop when we find a mismatch, as it is allowed to remove just one character we have two choices here,
 *
 * At mismatch, either remove character pointed by left pointer or remove character pointed by right pointer.
 * We will check both the cases, remember as we have traversed equal number of steps from both sides,
 * this mid string should also be a palindrome after removing one character, so we check two substrings,
 * one by removing left character and one by removing right character and if one of them is palindrome then
 * we can make complete string palindrome by removing corresponding character, and if both substrings are not palindrome
 * then it is not possible to make complete string a palindrome under given constraint.
 * O(n) Time O(1) Space
 */
public class ValidPalindromeII {
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left<=right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else{
                return isPalindrome(s,left,right-1) || isPalindrome(s,left+1,right);
            }
        }
        return true;
    }
    private static boolean isPalindrome(String str, int start, int end){
        while (start <= end){
            if (str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));//"deeee", "abc", "eeeed"
    }
}
