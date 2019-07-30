package Bootcamp.StringManipulation.DP;

public class RegexMatching {


    public static void main(String[] args) {
        RegexMatching rm = new RegexMatching();
        System.out.println(rm.matchRegexRecursive("aaa".toCharArray(),"ab*a*c*a".toCharArray()));
    }
}
