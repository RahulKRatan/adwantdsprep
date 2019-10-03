package Bootcamp.Arrays;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        boolean flag=false;
        if(divisor < 0){
            divisor = -(divisor);
            flag = true;
        }
        if(dividend == divisor){
            return 1;
        }
        int left = 0;
        int right = dividend/2;
        int num;
        while (left<=right){
            int pivot  = left + (right - left) / 2;
            num = pivot * divisor;
            if (num > dividend) right = pivot - 1;
            else if (num < dividend) left = pivot + 1;
            else return pivot;
        }

        return flag == true?-right:right;
    }

    public static void main(String[] args) {
        System.out.println(divide(1,1));
    }
}
