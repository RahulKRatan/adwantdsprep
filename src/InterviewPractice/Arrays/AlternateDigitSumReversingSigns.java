package InterviewPractice.Arrays;

public class AlternateDigitSumReversingSigns {

    public static int alternate(int n){
        boolean isOdd = (n % 2 == 1) ? true : false;
        int sumOdd = 0, sumEven = 0;
        while (n != 0)
        {
            // If current digit is odd positioned
            if (isOdd)
                sumOdd += n % 10;
            else
                sumEven += n % 10;
            // Invert state
            isOdd = !isOdd;
            // Remove last digit
            n /= 10;
        }
        return sumOdd-sumEven;
    }


    public static void main(String[] args) {
    System.out.println(alternate(52413));
    }
}
