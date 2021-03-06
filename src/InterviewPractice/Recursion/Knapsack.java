package InterviewPractice.Recursion;

public class Knapsack {

//    static int[] values = new int[]{1, 4, 5, 7};
//    static int[] weights = new int[]{1, 3, 4, 5};
//    static int W = 7;

    static int values[] = {10, 40, 30, 50};
    static int weights[] = {5, 4, 6, 3};
    static int W = 10;

    private static int knapsackRecursive(int i, int W) {
        if (i < 0) {
            return 0;
        }
        if (weights[i] > W) {
            return knapsackRecursive(i - 1, W);
        } else {
            return Math.max(knapsackRecursive(i - 1, W), knapsackRecursive(i - 1, W - weights[i]) + values[i]);
        }
    }

    private static int knapsack(int val[], int wt[], int W) {
        int N = wt.length; // Get the total number of items. Could be wt.length or val.length. Doesn't matter
        int[][] V = new int[N + 1][W + 1]; //Create a matrix. Items are in rows and weight at in columns +1 on each side
        //What if the knapsack's capacity is 0 - Set all columns at row 0 to be 0
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }
        //What if there are no items at home.  Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        for (int item = 1; item <= N; item++) {
            //Let's fill the values row by row
            for (int weight = 1; weight <= W; weight++) {
                //Is the current items weight less than or equal to running weight
                if (wt[item - 1] <= weight) {
                    //Given a weight, check if the value of the current item + value of the item that we could afford with the remaining weight
                    //is greater than the value without the current item itself
                    V[item][weight] = Math.max(val[item - 1] + V[item - 1][weight - wt[item - 1]], V[item - 1][weight]);
                } else {
                    //If the current item's weight is more than the running weight, just carry forward the value without the current item
                    V[item][weight] = V[item - 1][weight];
                }
            }
        }
        //Printing the matrix
        for (int[] rows : V) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        return V[N][W];
    }

    public static void main(String[] args) {
        System.out.println(knapsackRecursive(values.length - 1, W));
        System.out.println(knapsack(values,weights,W));
    }
}

