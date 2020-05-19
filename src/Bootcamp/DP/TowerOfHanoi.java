package Bootcamp.DP;

/**
 *
 * The pattern here is :
 * Shift 'n-1' disks from 'A' to 'B'.
 * Shift last disk from 'A' to 'C'.
 * Shift 'n-1' disks from 'B' to 'C'.

 For n disks, total 2n – 1 moves are required.
 http://www.cs.cmu.edu/~cburch/survey/recurse/hanoiimpl.html
 The solution to the Towers of Hanoi is inescapably O(2power n)
 */

public class TowerOfHanoi {

    // Java recursive function to solve tower of hanoi puzzle
    static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod)
    {
        if (n == 1)
        {
            System.out.println("Move disk 1 from rod " +  fromRod + " to rod " + toRod);
            return;
        }
        towerOfHanoi(n-1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from rod " +  fromRod + " to rod " + toRod);
        towerOfHanoi(n-1, auxRod, toRod, fromRod);
    }

    public static void main(String args[])
    {
        int n = 4; // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B');  // A, B and C are names of rods
    }
}
