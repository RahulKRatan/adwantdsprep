package InterviewPractice.Arrays;

import java.util.*;

//https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.
// Time complexity - O(NlogK)
/*
The advantage of this solution is it can deal with real-time(online) stream data. It does not have to know the size of the data previously.
The disadvatage of this solution is it is not the most efficient solution.

I had the exact same trouble in getting this understood. However, what helped me is the fact that it's the distance of each point from the origin that matters and not the relative distance between the points themselves!
e.g.: Let's say the two points are (2, 2) and (3, 3). We can deduce that (3, 3) is the farthest from the origin as below:

d1^2 = (2 - 0)^2 + (2 - 0)^2 = 2^2 + 2^2
d2^2 = (3 - 0)^2 + (3 - 0)^2 = 3^2 + 3^2

Now, deducing which among d1 and d2 is farthest from the origin is a trivial matter of computing d1^2 - d2^2 which is exactly what the comparator does. Hope this explanation helps!



 */
public class KClosestPointsOrigin {
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = maxHeap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{3,3},{5,-1},{-2,4}};
        int[][] result = kClosest(ints,2);
        System.out.println(result);
    }
}

/**
 * The advantage of this solution is it is very efficient.
 * The disadvatage of this solution are it is neither an online solution nor a stable one. And the K elements closest are not sorted in ascending order.
    public int[][] kClosest(int[][] points, int K) {
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
 */