package InterviewPractice.StringManipulation.Palindrome;

public class ValidPalindromeII {
    public static boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        boolean deleted = false;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else if(s.charAt(i)!=s.charAt(j) && !deleted){
                deleted = true;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }
}
