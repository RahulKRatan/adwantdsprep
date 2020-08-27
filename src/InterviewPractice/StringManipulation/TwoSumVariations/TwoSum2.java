package InterviewPractice.StringManipulation.TwoSumVariations;

public class TwoSum2 {
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (numbers[l] + numbers[r] != target) {
            if (numbers[l] + numbers[r] > target) r--;
            else l++;
        }
        return new int[]{l + 1, r + 1};
    }

    public static void main(String[] args) {
            int[] numbers = new int[]{2,7,11,15};
            twoSum(numbers,9);
    }

}
