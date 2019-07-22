package Bootcamp.StringManipulation;

/**
 * Time complexity : O(S) , where S is the sum of all characters in all strings.
 *
 * In the worst case all nn strings are the same. The algorithm compares the string S1S1 with the other strings
 * ​
 *  ] There are SS character comparisons, where SS is the sum of all characters in the input array.
 *
 * Space complexity : O(1)O(1). We only used constant extra space.
 */
public class LongestCommonPrefix {

    //  Horizontal scanning
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){

            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }

        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
