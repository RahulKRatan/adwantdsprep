package Bootcamp;


/**
 * Binary search
 * Palindrome
 * Permutations
 * Subsets -- similar to permutations
 * Tower of hanoi
 * Anagram finder = backtracking
 * N-QUEENS problem
 * https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/tutorial/
 * Sudoku - using backtracking
 * Cryptarithmetic
 * Looking for patterns ( Knapsack, travelling salesman, finding hidden words )
 */

public class RecusrsionTest {

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

    public static void binarySearch(int[] input, int value){

    }

    public static void main(String[] args) {
        int result = factorial(5);
        int fiboResult = fibonacci(5);
        System.out.println(result);
        System.out.println(fiboResult);

    }


}
