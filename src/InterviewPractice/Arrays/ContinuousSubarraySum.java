package InterviewPractice.Arrays;

import java.util.HashMap;
// find i and j such that sum(arr[i:j)) % k = 0

// accum[i] = sum(arr[0:i))
// sum(arr[i:j)) = accum[j] - accum[i]

// accum[j] = nj = a*k+b where a, b = divmod(nj, k)
// accum[i] = ni = c*k+d where c, d = divmod(ni, k)
// where 0<= b,d < k
// sum(arr[i:j)) = accum[j] - accum[i] = (a-c) * k + (b - d)
// we want that b = d

// instead of accum[i] what we really want is:

// r[i] = sum(arr[0:i)) % k
// sum(arr[i:j)) is a mutilpe of k if r[j] = r[i]

// cahche [sum(arr[0:i)) % k] -> i
//https://www.youtube.com/watch?v=3kD0nuwyPj8&ab_channel=RenZhang
public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, -1); // edge case for eg. 0,1,2,3 and k is 6. last element will have 0 and index would be 3-(-1)
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k; // instead of storing accumulated sum.. we can store remainders
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7},6));
    }
}
