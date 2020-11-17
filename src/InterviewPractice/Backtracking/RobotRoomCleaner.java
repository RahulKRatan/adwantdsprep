package InterviewPractice.Backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 *To indicate whether a cell has been cleaned(visited), we assume the start poin is (0, 0) and initial orientation is 0 as follows
 *
 *     0
 * 3  -|-  1
 *     2
 *each orientation is associated with a direction. directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; indicates movement.
 *
 * We can try moving in 4 directions for each step (starting from orientation x)
 * move forward - move; orientation x
 * move right - turnRight, move; orientation (x + 1) % 4
 * move backward - turnRight, turnRight, move; orientation (x + 2) % 4
 * move left - turnRight, turnRight, turnRight, move;  orientation (x + 3) % 4
 *
 * Time complexity : O(N−M), where N is a number of cells in the room and M is a number of obstacles.
 *
 * We visit each non-obstacle cell once and only once.
 * At each visit, we will check 4 directions around the cell. Therefore, the total number of operations would be 4 \cdot (N-M)4⋅(N−M).
 * Space complexity : O(N−M), where N is a number of cells in the room and M is a number of obstacles.
 *
 * We employed a hashtable to keep track of whether a non-obstacle cell is visited or not.
 */
public class RobotRoomCleaner {
    Robot robot;
    private static final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        clean(robot, 0, 0, 0, new HashSet<>());
    }

    private void clean(Robot robot, int x, int y, int curDirection, Set<String> visited) {
        // Cleans current cell.
        robot.clean();
        visited.add(x + " " + y);

        for (int nDirection = curDirection; nDirection < curDirection + 4; nDirection++) {
            int nx = directions[nDirection % 4][0] + x;
            int ny = directions[nDirection % 4][1] + y;
            if (!visited.contains(nx + " " + ny) && robot.move()) {
                clean(robot, nx, ny, nDirection % 4, visited);
            }
            // Changed orientation.
            robot.turnRight();//In order to change directions, so that the robot can move right, then down, then left, then up.
        }
        goBack();//backtrack to same position with orientation
    }
    public void goBack() {
        // Moves backward one step while maintaining the orientation.
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
    class Robot{
        public boolean move(){ return false;}
        public void turnRight(){};
        public void turnLeft(){};
        public void clean(){};
    }
}
