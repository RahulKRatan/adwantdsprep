package InterviewPractice.Arrays;

import java.util.LinkedList;

//goutam
/**
 *
 * at the end, all the negative star has to be on the left, and all the positive star has to be on the right.
 * from the left, a negative star will pass through if no positive star on the left;
 * keep track of all the positive stars moving to the right, the right most one will be the 1st confront the challenge of any future negative star.
 * if it survives, keep going, otherwise, any past positive star will be exposed to the challenge, by being popped out of the stack.
 *
 * Time Complexity: O(N), where N is the number of asteroids. Our stack pushes and pops each asteroid at most once.
 *
 * Space Complexity: O(N), the size of ans.
 */
public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> s = new LinkedList<>();// use LinkedList to simulate stack so that we don't need to reverse at end.
        for (int i : asteroids) {
            while (!s.isEmpty() && s.getLast() > 0 && s.getLast() < -i)
                s.pollLast();
            if (s.isEmpty() || i > 0 || s.getLast() < 0)
                s.add(i);
            else if (i < 0 && s.getLast() == -i)
                s.pollLast();
        }
        return s.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        int[] asteroids = new int[]{8,-8};
        System.out.println(asteroidCollision(asteroids));
    }


}
