package InterviewPractice.LinkedList;

import InterviewPractice.Trees.ListNode;

import java.util.HashMap;
import java.util.Map;

/*
Intuition
Assume the input is an array.
Do you know how to solve it?
Scan from the left, and calculate the prefix sum.
Whenever meet the seen prefix,
remove all elements of the subarray between them.


Solution 1
Because the head ListNode can be removed in the end,
I create a dummy ListNode and set it as a previous node of head.
prefix calculates the prefix sum from the first node to the current cur node.

Next step, we need an important hashmap m (no good name for it),
It takes a prefix sum as key, and the related node as the value.

Then we scan the linked list, accumulate the node's value as prefix sum.

If it's a prefix that we've never seen, we set m[prefix] = cur.
If we have seen this prefix, m[prefix] is the node we achieve this prefix sum.
We want to skip all nodes between m[prefix] and cur.next (exclusive).
So we simplely do m[prefix].next = cur.next.
We keep doing these and it's done.


Complexity
Time O(N), one pass
SpaceO(N), for hashmap
 */

public class RemoveZeroSumConsecutiveNodesLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        int prefix = 0;
        Map<Integer, ListNode> m = new HashMap<>();
        while (cur != null) {
            prefix += cur.val;
            if (m.containsKey(prefix)) {
                cur =  m.get(prefix).next;
                int p = prefix + cur.val;
                while (p != prefix) {
                    m.remove(p);
                    cur = cur.next;
                    p += cur.val;
                }
                m.get(prefix).next = cur.next;
            } else {
                m.put(prefix, cur);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
