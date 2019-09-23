package Bootcamp.StringManipulation.DP;

public class DecodeWays {

    public static int numDecodings(String s) {
        
        for(int i=0;i<s.length();i++){
            System.out.println(s.substring(i,i+1));
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
