package Bootcamp.StringManipulation;

public class ReverseString {

    public static void reverseString(char[] s) {
        int i = 0;
            while(i< s.length/2){
                char temp = s[i];
                s[i] = s[(s.length-1) - i];
                s[(s.length-1) - i] = temp;
                i++;
            }
            for(int j=0;j<s.length;j++){
                System.out.println(s[j]);
            }
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'h','e','l','l','o'};
        reverseString(chars);
    }
}
