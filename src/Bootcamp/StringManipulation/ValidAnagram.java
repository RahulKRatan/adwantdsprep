package Bootcamp.StringManipulation;

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char temp1[] = s.toCharArray();
        char temp2[] = t.toCharArray();
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        String s1 = new String(temp1);
        String s2 = new String(temp2);
        if(s1.equals(s2)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }


}
