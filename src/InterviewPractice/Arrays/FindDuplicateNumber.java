package InterviewPractice.Arrays;

//https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.
///https://medium.com/solvingalgo/solving-algorithmic-problems-find-a-duplicate-in-an-array-3d9edad5ad41
// important

/**
 * Floyd's algorithm consists of two phases and uses two pointers, usually called tortoise and hare.
 *
 * In phase 1, hare = nums[nums[hare]] is twice as fast as tortoise = nums[tortoise].
 * Since the hare goes fast, it would be the first one who enters the cycle and starts to run around the cycle.
 * At some point, the tortoise enters the cycle as well, and since it's moving slower the hare
 * catches the tortoise up at some intersection point. Now phase 1 is over, and the tortoise has lost.
 *
 * In phase 2, we give the tortoise a second chance by slowing down the hare,
 * so that it now moves with the speed of tortoise: tortoise = nums[tortoise], hare = nums[hare].
 * The tortoise is back at the starting position, and the hare starts from the intersection point.
 */


public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums){
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        System.out.print(findDuplicate(nums));
    }


}
