package InterviewPractice.Arrays;


/**
 * Time complexity : {O}(N) since it's one pass along the array of length NN.
 *
 * Space complexity : O}(1) since it's a constant space solution.
 *
 * Algorithm :
 * if arr[i] is red - swap arr[i] with arr[red/first] and increment red & i
 * if arr[i] is blue - swap arr[i] with arr[blue/third] and decrement blue and i
 * else just increment i ( in case the element is green )
 *
 */
public class SortColors {

    public static int[] sortColors(int[] nums) {
        int first = 0;
        int third = nums.length-1;
        for(int i=0;i<=third;i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[first];
                nums[first] = temp;
                first++;
            }else if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[third];
                nums[third] = temp;
                third--;
                i--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        int[] result = sortColors(nums);
        System.out.println(result);
    }
}
