package Bootcamp.Arrays;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        while (inLoop.add(n)){
            int temp = 0;
            while(n!=0){
                int val = n%10;
                temp = temp + (val*val);
                n = n/10;
            }
            if (temp == 1)
                return true;
            n = temp;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }
}
