package InterviewPractice.StringManipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * we can conduct two steps by using two pointers for this probelm:
 * 1. check feasibility from left to right
 * 2. check optimization from right to left
 * we can traverse from left to right, find a possible candidate until reach the first ending character of T
 * eg: for the string s = abcdebdde and t = bde, we should traverse s string until we find first e,
 * i.e. abcde, then traverse back from current "e" to find if we have other combination of bde with smaller
 * length.
 *  right: fast pointer that always points the last character of T in S
 *  left: slow pointer that used to traverse back when right pointer find the last character of T in S
 *  tIndex: third pointer used to scan string T
 *  minLen: current minimum length of subsequence
 * */
public class MinimumWindowSubsequence {
    public static String minWindow(String S, String T) {

    }

    public static void main(String[] args) {
    System.out.println(minWindow("abcdebdde","bde"));
    }
}
