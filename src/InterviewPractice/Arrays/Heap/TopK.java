package InterviewPractice.Arrays.Heap;

import java.util.*;
/*
*Complexity Analysis
*
*Time complexity : O(Nlog(k)). The complexity of Counter method is \mathcal{O}(N)O(N). To build a heap and output list takes \mathcal{O}(N \log(k))O(Nlog(k)). Hence the overall complexity of the algorithm is \mathcal{O}(N + N \log(k)) = \mathcal{O}(N \log(k))O(N+Nlog(k))=O(Nlog(k)).
*
 *Space complexity : O(N) to store the hash map.
 * https://leetcode.com/problems/top-k-frequent-elements/discuss/81635/3-Java-Solution-using-Array-MaxHeap-TreeMap
*/
public class TopK {

    static List<Integer> topK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        // decreasing comparator
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,3};
        int k = 2;
        topK(arr,k);
    }
}
