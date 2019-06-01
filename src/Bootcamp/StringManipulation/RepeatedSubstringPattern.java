package Bootcamp.StringManipulation;

public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        int i=1; int len = s.length();
        int j = len-1;
        if(s.length()%2 != 0){
            return false;
        }
        while (i <= s.length()/2 || j >= s.length()/2){
            if(s.substring(0,i).equals(s.substring(j,len))){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
    }
}
