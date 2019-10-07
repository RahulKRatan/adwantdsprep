package Bootcamp.Arrays;

import java.util.Random;

/**
 * Time complexity : O(n)
 *
 * The Fisher-Yates algorithm runs in linear time, as generating a random index and swapping two values can be done in constant time.
 *
 * Space complexity : O(n)
 *
 * Although we managed to avoid using linear space on the auxiliary array from the brute force approach, we still need it for reset, so we're stuck with linear space complexity.
 */
public class ShuffleArray {
    int[] array;
    private int[] original;

    Random rand = new Random();
    public ShuffleArray(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = original;
        original = original.clone();
        /*
        This is so that you do not mess up your array. Java is pass by value, but the value of an array, is the pointer / reference to the array. The clone creates a deep copy.
        https://stackoverflow.com/questions/12757841/are-arrays-passed-by-value-or-passed-by-reference-in-java

        In the reset function 'array' is assigned 'original'. Now, if 'array' is modified, it will modify 'original' as well,
        because they both point to the same location in memory (they are objects, not primitives), so, original = original.clone(),
        makes a deep copy of original, and then assigns it to original. Now 'array' and 'original' have the same values,
        but point to different copies in memory, so they are independent from one another, if array is modified, it will do nothing to original, which we want to keep the same.
         */
        return array;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min; // suppose we did rand.nextInt(max) + min instead of what was stated. You could possibly output max + min - 1, which can be out of bounds.
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3};
        ShuffleArray shuffleArray = new ShuffleArray(ints);
        shuffleArray.reset();
        shuffleArray.shuffle();
    }

}
