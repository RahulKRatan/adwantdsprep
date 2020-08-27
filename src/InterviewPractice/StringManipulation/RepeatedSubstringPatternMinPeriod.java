package InterviewPractice.StringManipulation;

public class RepeatedSubstringPatternMinPeriod {

    public static int repeatedSubstringPattern(String str) {
        int l = str.length();
        for(int i=l/2;i>=1;i--) {
            if(l%i==0) {
                int m = l/i;
                String subS = str.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<m;j++) {
                    sb.append(subS);
                }
                if(sb.toString().equals(str)) return m;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abcabcabc"));
    }
}
