package InterviewPractice.Arrays;

public class IntegerToRoman {

    public static String intToRoman(int number) {
        if (number < 1 || number > 3999) return "";

        // roman and value pair are important
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


        StringBuilder result = new StringBuilder();
        int i = 0;
        //iterate until the number becomes zero, NO NEED to go until the last element in roman array
        while (number >0) {
            while ( number >= values[i]) {
                number -= values[i];
                result.append(roman[i]);
            }
            i++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1234));
    }
}