package InterviewPractice.Arrays;

public class MinimumCostMoveChipsTheSamePosition {

    public static int minCostToMoveChips(int[] position) {
        int evenPosition = 0;
        int oddPosition = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                evenPosition++;
            } else {
                oddPosition++;
            }
        }
        return Math.min(oddPosition, evenPosition);
    }

    public static void main(String[] args) {
        int[] positions = new int[]{2,2,2,3,3};
        System.out.println(minCostToMoveChips(positions));
    }
}
