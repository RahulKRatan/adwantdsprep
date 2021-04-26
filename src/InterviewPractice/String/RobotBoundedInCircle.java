package InterviewPractice.String;

/**
 * Algorithm
 *
 * Let's use numbers from 0 to 3 to mark the directions: north = 0, east = 1, south = 2, west = 3.
 * In the array directions we could store corresponding coordinates changes, i.e. directions[0] is to go north, directions[1] is to go east, directions[2] is to go south, and directions[3] is to go west.

 * The initial robot position is in the center x = y = 0, facing north idx = 0.
 *
 * Now everything is ready to iterate over the instructions.
 *
 * If the current instruction is R, i.e. to turn on the right, the next direction is idx = (idx + 1) % 4.
 * Modulo here is needed to deal with the situation - facing west, idx = 3, turn to the right to face north, idx = 0.
 *
 * If the current instruction is L, i.e. to turn on the left, the next direction could written in a symmetric way idx = (idx - 1) % 4.
 * That means we have to deal with negative indices. A more simple way is to notice that 1 turn to the left = 3 turns to the right: idx = (idx + 3) % 4.
 *
 * If the current instruction is to move, we simply update the coordinates: x += directions[idx][0], y += directions[idx][1].
 *
 * After one cycle we have everything to decide. It's a limit cycle trajectory if the robot is back to the center: x = y = 0 or if the robot doesn't face north: idx != 0.
 *
 * Explanation
 * (x,y) is the location of chopper.
 * d[i] is the direction he is facing.
 * i = (i + 1) % 4 will turn right
 * i = (i + 3) % 4 will turn left
 * Check the final status after instructions.
 *
 *People are asking for a proof. I thought my explanation above is already the proof?
 * If robot return origin, it will be in the circle.
 * If robot ends with other direction (as shown in the diagram), it will be in the circle.
 * Otherwise, not back to the origin, and still faces north, it will be further and further after instructions and won't be in a circle.
 * Isn't it a proof good enough?
 *
 *              N (0)
 *                |
 *        W (3) ------ E (1)
 *                |
 *             S (2)
 *
 *
 * Hope looking at it like this helps
 *
 * Complexity
 * Time O(N)
 * Space O(1)
 */
public class RobotBoundedInCircle {
    public static boolean isRobotBounded(String instructions) {
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Initial position is in the center
        int x = 0, y = 0;
        // facing north
        int idx = 0;

        for (char i : instructions.toCharArray()) {
            if (i == 'L')
                idx = (idx + 3) % 4; // 3 times right is left i.e + 3
            else if (i == 'R')
                idx = (idx + 1) % 4;
            else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }

        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (idx != 0);
    }

    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
    }
}
