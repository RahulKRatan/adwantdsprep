package Bootcamp.StringManipulation;

public class ReverseWordsInString {

    public static String reverseWords(String s) {
        System.out.println(reverse(s));
        return "";
    }

    public static String reverse(String string){
        char[] str = string.trim().toCharArray();
        int i=0;
        int j = str.length-1;
        while(i<j){
            char temp = str[i];
            str[i] = str [j];
            str[j] = temp;
            i++;j--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

}
