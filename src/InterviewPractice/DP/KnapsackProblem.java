package InterviewPractice.DP;

public class KnapsackProblem {

    /*
    Time complexity of this naive recursive solution is exponential (2^n).
    In the following recursion tree, K() refers to knapSack().  The two
    parameters indicated in the following recursion tree are n and W.
    The recursion tree is for following sample inputs.
    wt[] = {1, 1, 1}, W = 2, val[] = {10, 20, 30}

                       K(3, 2)         ---------> K(n, W)
                   /            \
                 /                \
            K(2,2)                  K(2,1)
          /       \                  /    \
        /           \              /        \
       K(1,2)      K(1,1)        K(1,1)     K(1,0)
       /  \         /   \          /   \
     /      \     /       \      /       \
K(0,2)  K(0,1)  K(0,1)  K(0,0)  K(0,1)   K(0,0)
Recursion tree for Knapsack capacity 2 units and 3 items of 1 unit weight.
     */
    static int knapSack(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n-1] > W)
            return knapSack(W, wt, val, n-1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else return Integer.max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1)); // important first recursion - delete weight
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    /*
    Time Complexity: O(nW) where n is the number of items and W is the capacity of knapsack.
    https://www.youtube.com/watch?time_continue=5&v=ywiH-zRH1mA&feature=emb_logo
     */
    static int knapSackDP(int W, int wt[], int val[], int n)
    {
        // 2D array since we have two changing behavoirs of weight and values.
        int K[][] = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (int i = 0; i <= n; i++)
        {
            for (int w = 0; w <= W; w++)
            {
                if (i==0 || w==0) // Base case as recursion
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = Integer.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]); // if weight is less then Max of included and excluded item.
                else
                    K[i][w] = K[i-1][w]; // if weight is greater than w then ignore
            }
        }

        return K[n][W];
    }

    public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }

}
