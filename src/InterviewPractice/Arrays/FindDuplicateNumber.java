package InterviewPractice.Arrays;

//https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.
///https://medium.com/solvingalgo/solving-algorithmic-problems-find-a-duplicate-in-an-array-3d9edad5ad41
// important
public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums){
        if (nums.length > 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        System.out.print(findDuplicate(nums));
    }


}
