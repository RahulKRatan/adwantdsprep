package Bootcamp.StringManipulation;

public class ReverseWordsInString {

    public static String reverseWords(String s) {
       String temp = reverse(s);
        String t[] = temp.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i< t.length;i++){
            stringBuilder.append(reverse(t[i]) + " ");
        }
        return stringBuilder.toString();
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
        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }

}
