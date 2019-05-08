package Bootcamp.StringManipulation;

import java.util.ArrayList;
import java.util.HashMap;
/*
Thank you! You gave me the missing piece of the puzzle - I couldn't figure out how to remove an element from the array
without shifting the elements and updating their indexes in the map, causing the removal to cost O(N).
The idea of swapping the item to be deleted with the last item is simply brilliant !
Why can't we simply use a hashmap for remove(), insert() and getRandom()?
Why a arrayList is needed? It seems like the hashmap alone can fulfill all operations?
The question requires getRandom() in O(1) time and each element needs to be returned with the same probability.
You can't do that with just hashmap itself.
 does it make any difference if we change ArrayList to a LinkedList?
  It does. For a linked list get(index) is a linear time (O(n)) operation since it requires that you search through the whole list in the worst case.
  Where as an arraylist is O(1) lookup since it uses an array as it's internal data structure.
  https://leetcode.com/problems/insert-delete-getrandom-o1/discuss/85401/Java-solution-using-a-HashMap-and-an-ArrayList-along-with-a-follow-up.-(131-ms)
 */
public class InsertDeleteGetRandomO1 {

    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if ( contain ) return false;
        locs.put( val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }


}
