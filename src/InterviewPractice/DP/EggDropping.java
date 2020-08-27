package InterviewPractice.DP;

/*
https://www.youtube.com/watch?time_continue=3&v=KVfxgpI3Tv0&feature=emb_logo
 */
public class EggDropping {

    /* Function to get minimum number of
    trials needed in worst case with n
    eggs and k floors */
    static int eggDrop(int eggs, int floors)
    {
        // If there are no floors, then
        // no trials needed. OR if there
        // is one floor, one trial needed.
        if (floors == 1 || floors == 0)
            return floors;

        // We need k trials for one egg
        // and k floors
        if (eggs == 1)
            return floors;

        int min = Integer.MAX_VALUE;

        // Consider all droppings from
        //1st floor to kth floor and
        // return the minimum of these
        // values plus 1.
        for (int x = 1; x <= floors; x++)
        {
            int res = Math.max(eggDrop(eggs-1, x-1), eggDrop(eggs, floors-x));
            if (res < min)
                min = res;
        }

        return min + 1;
    }


    /* Function to get minimum number of trials needed in worst
    case with n eggs and k floors
    Time Complexity: O(nk^2)
    Auxiliary Space: O(nk)
    */
    static int eggDropDP(int n, int k)
    {
       /* A 2D table where entery eggFloor[i][j] will represent minimum
       number of trials needed for i eggs and j floors. */
        int eggFloor[][] = new int[n+1][k+1];

        // We need one trial for one floor and 0 trials for 0 floors
        for (int i = 1; i <= n; i++)
        {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        // We always need j trials for one egg and j floors.
        for (int j = 1; j <= k; j++)
            eggFloor[1][j] = j;

        // Fill rest of the entries in table using optimal substructure
        // property
        for (int i = 2; i <= n; i++)
        {
            for (int j = 2; j <= k; j++)
            {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++)
                {
                    int res = 1 + Integer.max(eggFloor[i-1][x-1], eggFloor[i][j-x]);
                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }

        // eggFloor[n][k] holds the result
        return eggFloor[n][k];

    }

    /* Driver program to test to pront printDups*/
    public static void  main(String args[] )
    {
        int n = 2, k = 10;
        System.out.println("Minimum number of trials in worst case with "+n+"  eggs and "+k+
                " floors is "+eggDrop(n, k));
    }
}
