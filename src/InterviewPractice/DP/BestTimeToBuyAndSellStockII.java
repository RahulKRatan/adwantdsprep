package InterviewPractice.DP;

/*
Time complexity : O(n). Single pass.
Space complexity: O(1). Constant space needed.

In this case, instead of looking for every peak following a valley,
we can simply go on crawling over the slope and keep on adding the profit obtained from every consecutive transaction.
 In the end,we will be using the peaks and valleys effectively,
  but we need not track the costs corresponding to the peaks and valleys along with the maximum profit,
  but we can directly keep on adding the difference between the consecutive numbers of the array if
  the second number is larger than the first one, and at the total sum we obtain will be the maximum profit.

 */
public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i] > prices[i-1]){
                max+= prices[i]-prices[i-1];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }

}
