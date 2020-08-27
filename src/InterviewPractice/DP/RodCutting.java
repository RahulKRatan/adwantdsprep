package InterviewPractice.DP;

/*
https://www.radford.edu/~nokie/classes/360/dp-rod-cutting.html
https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
 */
public class RodCutting {

    /* Returns the best obtainable price for a rod of length
       n and price[] as prices of different pieces
       cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}
       */
    private static int cutRod(int price[], int n)
    {
        if(n<=0)
            return 0;

        int max_val = Integer.MIN_VALUE;
        for (int i = 0; i<n; i++) {
            max_val = Math.max(max_val, price[i] + cutRod(price, n - i - 1));
        }

        return max_val;
    }

    /* Returns the best obtainable price for a rod of
   length n and price[] as prices of different pieces
   Time Complexity of the above implementation is O(n^2) which is much better than the worst-case time complexity of Naive Recursive implementation.
   */
    private static int cutRodDP(int price[],int n)
    {
        int val[] = new int[n+1];
        val[0] = 0;

        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, price[j] + val[i - j - 1]);
            }
            val[i] = max;
        }

        return val[n];
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "+ cutRod(arr, size));
    }
}
