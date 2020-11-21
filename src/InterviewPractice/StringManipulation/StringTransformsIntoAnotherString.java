package InterviewPractice.StringManipulation;

import java.util.HashMap;
import java.util.HashSet;

/**
 * I would recommend putting two words in two columns vertically, something like this,
 *
 * s1="ace", s2="cea", draw arrows between each transformation
 * key  -> value
 * a    ->    c
 * c    ->    e
 * e    ->    a
 * If a value shows up later as a key, then it makes a linkedlist structure,
 * and if a value has already been a key, then there is a cycle (in this case, the last "a" is the key in the first row).
 *
 * For linkedlist without cycle we can just backward substitute the key with the value, there exists a way of converting s1 to s2 for sure.
 * For linkedlist with a cycle, such as "a -> c -> e -> a", we need to break the loop and use a temporary variable to cache the point of break,
 * in this case, it becomes the transformation with two steps: "a -> tmp" and "tmp -> c -> e -> a".
 * Now the bottleneck is if we can find a temporary variable to carry the conversion, if there is one, then the conversion is viable.
 * https://www.youtube.com/watch?v=JXEBGi3mjfE&ab_channel=KelvinChandra
 * Time O(N) for scanning input
 * Space O(26) to record the mapping
 */
public class StringTransformsIntoAnotherString {
    public static boolean canConvert(String str1, String str2) {
        HashSet<Character> s2 = new HashSet<>();
        HashMap<Character,Character> mappingCharacter = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            s2.add(str2.charAt(i));
            if(mappingCharacter.containsKey(str1.charAt(i)) && mappingCharacter.get(str1.charAt(i)) != str2.charAt(i)){
                return false;
            }
            mappingCharacter.put(str1.charAt(i),str2.charAt(i));
        }
        if(!str1.equals(str2) && mappingCharacter.size() == 26 && s2.size() == 26){ //so we have 26 one-to-one mappings. If str1 is not the same as str2, cycle must exist, but there is no unused character to break the cycle. So return false.
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(canConvert("aabcc","ccdee"));
    }
}
