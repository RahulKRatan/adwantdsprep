package Bootcamp.Arrays;

/*
Time complexity : O(logN).
Space complexity : O(1).
 */

public class SqrtRoot {

    public static int mySqrt(int x) {
        if (x < 2) return x;

        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(25));
    }
}
