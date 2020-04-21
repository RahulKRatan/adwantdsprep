package Bootcamp.StringManipulation;


public class ValidParenthesisString {

    public static boolean checkValidString(String s) {
        if(s.isEmpty()) return true;

        char[] chars = s.toCharArray();
        int leftWild = 0;
        int left = 0;
        //O(N) complexity
        for(char c : chars){
            // making sure all right tokens have a pair
            if(c == ')'){
                if(leftWild == 0) return false;
                leftWild --;
            }else {
                leftWild++;
            }
            // making sure all left tokens have a pair
            if(c=='('){
                left++;
            }else {
                left = Integer.max(0,left-1);
            }
        }

        return left ==0;
    }

    public static void main(String[] args) {
        System.out.println(checkValidString("(*))"));
    }
}
