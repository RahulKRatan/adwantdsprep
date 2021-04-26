package InterviewPractice.String;

public class ReverseVowelsE2E {

    public static String reverseVowels(String s) {
        String vowels = "AEIOUaeiou";
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length/2;i++){
            char start = chars[i];
            char end = chars[(chars.length-1) - i];
            if(vowels.contains(start+"") && vowels.contains(end+"")){
                char temp = end;
                chars[(chars.length-1) - i] = start;
                chars[i] = temp;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {

    System.out.print(reverseVowels("leetcode"));
    }
}
