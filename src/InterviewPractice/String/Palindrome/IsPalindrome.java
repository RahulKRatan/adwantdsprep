package InterviewPractice.String.Palindrome;

/**
 * The following is a solution with O(n) time complexity and O(1) space complexity.
 */
public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        s =  s.replaceAll("[^a-zA-Z0-9]+", "").trim().toLowerCase();
        int length = s.length();
        int i = s.length()-1;
        int j = 0;
        while (j< length/2){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.print(isPalindrome(str));
    }
}
