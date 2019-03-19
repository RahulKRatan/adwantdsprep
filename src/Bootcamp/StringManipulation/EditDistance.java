package Bootcamp.StringManipulation;

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        return editDistance(word1,word2,word1.length(),word2.length());
    }

    static int min(int x,int y,int z)
    {
        if (x<=y && x<=z) return x;
        if (y<=x && y<=z) return y;
        else return z;
    }

    public static int editDistance(String s1, String s2, int i, int j){
        // If first string is empty, the only option is to
        // insert all characters of second string into first
        if(i==0){
            return j;
        }
        // If second string is empty, the only option is to
        // remove all characters of first string
        if(j==0){
            return i;
        }
        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return editDistance(s1,s2,i-1,j-1);
        }
        //If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min(editDistance(s1,s2,i-1,j),editDistance(s1,s2,i,j-1),editDistance(s1,s2,i-1,j-1));
    }

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(minDistance(s1,s2));
    }
}
