package InterviewPractice.Arrays;

import java.util.ArrayList;
import java.util.List;
/*
        Time : O(N)
        space : O(1)
 */
public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i=1;i<=n;i++){

            if(i%15 == 0){
                result.add("FizzBuzz");
            }else if(i%5 == 0){
                result.add("Buzz");
            }else if(i%3 == 0){
                result.add("Fizz");
            }else {
                result.add(""+i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> res = fizzBuzz(15);
        System.out.println(res);
    }
}
