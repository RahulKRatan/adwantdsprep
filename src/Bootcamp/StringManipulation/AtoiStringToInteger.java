package Bootcamp.StringManipulation;

public class AtoiStringToInteger {

    public static int myAtoi(String str){
        str = str.trim();
        if(str == null || str.length() < 1) {
            return 0;
        }
        int i=0;
        char flag = '+';
        if(str.charAt(0) == '-'){
            flag = '-';
            i++;
        }
        else if(str.charAt(0)=='+'){
            flag = '+';
            i++;
        }
        int result = 0;
        while(i<str.length()&& str.charAt(i) >='0' && str.charAt(i)<='9'){
            result = result*10 + (str.charAt(i)-'0');
            i++;
        }
        if(flag == '-'){
            result = -result;
        }
        if(result>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }
}
