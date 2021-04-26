package InterviewPractice.String;

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
                System.out.print(s[j]);
                System.out.println();
            }
    }

    public static void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void recursiveReverse(char[] s){
        recursiveHelper(s,0,s.length);
        String result = new String(s);
        System.out.println(result);
    }

    public static void recursiveHelper(char[] s, int start, int end){
        if(start < end/2){
            return;
        }
        recursiveHelper(s,start+1,end-1);
        swap(s,start,end);
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'h','e','l','l','o'};
        reverseString(chars);
        recursiveReverse(chars);
    }
}
