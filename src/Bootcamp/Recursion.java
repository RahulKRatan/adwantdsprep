package Bootcamp;


/**
 * Binary search - DONE
 * Palindrome - DONE
 * Permutations - DONE
 * Subsets -- similar to permutations
 * Tower of hanoi
 * Anagram finder = backtracking
 * N-QUEENS problem
 * https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/tutorial/
 * Sudoku - using backtracking
 * Cryptarithmetic
 * Looking for patterns ( Knapsack, travelling salesman, finding hidden words )
 */

public class Recursion {


    public static int factorial(int n) {

        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int fibonacci(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static boolean binarySearch(int[] input, int start, int end, int value) {

        int mid = (start + end) / 2;

        if (end < start) {
            return false;
        }
        if (input[mid] == value) {
            return true;
        }
        if (input[mid] > value) {
            return binarySearch(input, start, mid - 1, value);
        }
        if (input[mid] < value) {
            return binarySearch(input, mid + 1, end, value);
        }
        return false;
    }

    public static boolean palindrome(String str, int start, int end) {
        if (start == end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        if (start < end + 1) {
            return palindrome(str, start + 1, end - 1);
        }
        return false;
    }

    public static void permutations(String prefix, String value) {
        int n = value.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations(prefix + value.charAt(i), value.substring(0, i) + value.substring(i + 1, n));
            }
        }
    }

    public static void main(String[] args) {
        int result = factorial(5);
        int fiboResult = fibonacci(5);
        int[] inputBinary = new int[]{2,3,6,7,9,13,18,25};
        String str = "adwda";

        System.out.println(result);
        System.out.println(fiboResult);
        System.out.println(binarySearch(inputBinary, 0, inputBinary.length - 1, 23));
        System.out.println(palindrome(str, 0, str.length() - 1));
        permutations("", "abc");

    }


}
