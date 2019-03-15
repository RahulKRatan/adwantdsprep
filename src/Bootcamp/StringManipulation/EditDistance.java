package Bootcamp.StringManipulation;

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        return editDistance(word1,word2,0,0);
    }

    public static int editDistance(String s1, String s2, int i, int j){
        if(i==s1.length() || j==s2.length()){
            return Integer.max(s1.length()-i,s2.length()-j);
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return editDistance(s1,s2,i+1,j+1);
        }

        int temp = editDistance(s1,s2,i+1,j) < editDistance(s1,s2,i,j+1) ? editDistance(s1,s2,i+1,j):editDistance(s1,s2,i,j+1);
        int result = editDistance(s1,s2,i+1,j+1) < temp ? editDistance(s1,s2,i+1,j+1):temp;

        return 1 + result;
    }

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(minDistance(s1,s2));
    }
}
