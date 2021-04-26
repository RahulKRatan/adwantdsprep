package InterviewPractice.String;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int count = 0;
        s = s.trim();
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i) == ' '){
                break;
            }
            count = count + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "b a  ";
        System.out.print(lengthOfLastWord(str));
    }

}
