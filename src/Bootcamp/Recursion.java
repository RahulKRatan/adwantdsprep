package Bootcamp;


import com.sun.istack.internal.NotNull;

/**
 * Binary search - DONE
 * Palindrome - DONE
 * Permutations - DONE
 * Subsets -- similar to permutations( combinations ) - DONE
 * Anagram - DONE
 * Tower of hanoi - DONE
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

    public static void permutations(String prefix, @NotNull String value) {
        int n = value.length();
        if (n == 0 ) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutations(prefix + value.charAt(i), value.substring(0, i) + value.substring(i + 1, n));
            }
        }
    }

    public static void permutationsKelemts(String prefix, @NotNull String value, int range){
        int n = value.length();
        if (n == range-1 && prefix.length() == range) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutationsKelemts(prefix + value.charAt(i), value.substring(0, i) + value.substring(i + 1, n),range);
            }
        }
    }

    public static void subsets(String prefix,@NotNull String value) {
        System.out.println(prefix);
        for (int i = 0; i < value.length(); i++) {
            subsets(prefix + value.charAt(i), value.substring(i + 1));
        }
    }

    public static void subsetKelements(String prefix, String value,int range){
        if (range == 0) { // important - for every 3rd iteration range will be 0 and reset to 3
            System.out.println(prefix);
        }
        for (int i = 0; i < value.length(); i++) {
            subsetKelements(prefix + value.charAt(i), value.substring(i + 1), range - 1);
        }
    }

    public static void anagram(String prefix, @NotNull String input, @NotNull String compare) {
        int n = input.length();
        if (n == 0 && prefix.equals(compare)) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                anagram(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1, n), compare);
            }
        }
    }

    public static void towerOfHanoi(int n, String start, String intermediate, String end) {
        /*Base Case - When n = 1
        Move the disc from start pole to end pole
        Recursive Case - When n > 1
        Step 1: Move (n-1) discs from start pole to auxiliary pole.
        Step 2: Move the last disc from start pole to end pole.
        Step 3: Move the (n-1) discs from auxiliary pole to end pole.
        Steps 1 and 3 are recursive invocations of the same procedure.
        */
        if (n == 0) {
            return;
        }
        towerOfHanoi(n - 1, start, end, intermediate);
        System.out.println("Move \"" + n + "\" from " + start + " --> " + end);
        towerOfHanoi(n - 1, intermediate, start, end);
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
        permutationsKelemts("", "abcde",3);
        subsets("", "abc");
        subsetKelements("", "abcde", 3);
        anagram("", "dbca", "abcd");
        towerOfHanoi(3, "Pole1", "Pole2", "Pole3");

    }


}
