package InterviewPractice.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Intuition behind solution: Create a mapping for digits to letters (i.e. 2 represent the letters a, b, and c).
 * Call a recursive function to populate or letter combinations. Pass the recursive function our array list (result) that holds all our completed combinations,
 * the numbers we're given, the mapping from numbers to letters, the current index we are on, and a string representing our current combination.
 * Inside each recursive call, check if we have traversed all the digits we are given (index == digits.length()),
 * if we have, add the current combination to our result and return to ensure we don't continue.
 * Otherwise, get the letter mapping for the current digit we're on given by (mapping[digits.charAt(i) - '0').
 * Iterate through each possible letter that the current digit represents and at each iteration pass to the next recursive call letters[i],
 * updating our representation of our current combination (current + letters[i]) and our index (index + 1).
 * Once all the recursive calls terminate, we have successfully generated all possible letter combinations so we return result.
 */
public class LetterCombinationsPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        String[] mapping = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        recursive(digits,mapping,"",0,res);
        return res;
    }

    public static void recursive(String digits, String[] mapping, String current, int index,List<String> res){
        if(current.length() == digits.length()){
            res.add(current);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for(int i=0;i<letters.length();i++){
         recursive(digits,mapping,current+letters.charAt(i),index+1,res);
        }
    }

    public static void main(String[] args) {
        List<String> result = letterCombinations("23");
        System.out.println(result);
    }
}
