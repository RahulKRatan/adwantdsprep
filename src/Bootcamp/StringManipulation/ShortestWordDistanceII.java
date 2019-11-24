package Bootcamp.StringManipulation;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * In the constructor of the class, we simply iterate over the given list of words and prepare a dictionary, mapping a word to all it's locations in the array.
 * Since we process all the words from left to right, we will get all the indices in a sorted order by default for all the words. So, we don't have to sort the indices ourselves.
 * Let's call the dictionary that we build, locations.
 * For a given pair of words, obtain the list of indices (appearances inside the original list/array of words). Let's call the two arrays loc1 and loc2.
 * Initialize two pointer variables l1 = 0 and l2 = 0.
 * For a given l1 and l2, we first update (if possible) the minimum difference (distance) till now i.e. dist = min(dist, abs(loc1[l1] - loc2[l2])).
 * Then, we check if loc1[l1] < loc2[l2] and if this is the case, we move l1 one step forward i.e. l1 = l1 + 1. Otherwise, we move l2 one step forward i.e. l2 = l2 + 1.
 * We keep doing this until all the elements in the smaller of the two location arrays are processed.
 * Return the global minimum distance between the words.
 *
 * The time complexity of the shortest method is now O(M+N). Since M+N < size of word list, the time is O(K) where k is the list size.
 */
public class ShortestWordDistanceII {

    HashMap<String, ArrayList<Integer>> locations;

    public ShortestWordDistanceII(String[] words) {
        locations = new HashMap<>();
        for(int i=0; i<words.length; i++){
            if(locations.containsKey(words[i])){
                locations.get(words[i]).add(i);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                locations.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> l1 = locations.get(word1);
        ArrayList<Integer> l2 = locations.get(word2);

        int result = Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while(i<l1.size() && j<l2.size()){
            result = Math.min(result, Math.abs(l1.get(i)-l2.get(j)));
            if(l1.get(i)<l2.get(j)){
                i++;
            }else{
                j++;
            }
        }

        return result;
    }
}
