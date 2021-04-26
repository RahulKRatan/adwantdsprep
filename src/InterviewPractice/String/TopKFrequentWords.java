package InterviewPractice.String;

import java.util.*;

/**
 * Intuition and Algorithm
 *
 * Count the frequency of each word, then add it to heap that stores the best k candidates.
 * Here, "best" is defined with our custom ordering relation, which puts the worst candidates at the top of the heap.
 * At the end, we pop off the heap up to k times and reverse the result so that the best candidates are first.
 *
 * In Python, we instead use heapq.heapify, which can turn a list into a heap in linear time, simplifying our work.
 *
 *
 *
 * Time Complexity: O(Nlogk), where N is the length of words.
 * We count the frequency of each word in O(N) time,
 * then we add N words to the heap, each in O(logk) time. Finally,
 * we pop from the heap up to kk times. As k \leq Nk≤N, this is O(Nlogk) in total.
 *
 * In Python, we improve this to O(N + k \log {N})O(N+klogN): our heapq.heapify operation and counting operations are O(N)O(N), and each of kk heapq.heappop operations are O(\log {N})O(logN).
 *
 * Space Complexity: O(N), the space used to store our count.
 */
public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        // Building heap - important
        PriorityQueue<String> minHeap = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2) );

        for (String word: count.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) minHeap.poll();
        }

        List<String> ans = new ArrayList<>();
        while (!minHeap.isEmpty()) ans.add(minHeap.poll());
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words,2));
    }
}

/*
Alternate sorting solution
Time - O(NlogN), space O(N)

public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);
 }
 */