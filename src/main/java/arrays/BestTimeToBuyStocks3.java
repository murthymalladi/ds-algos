package arrays;

/**
 * Created by dmalladi on 2/23/2019.
 */
public class BestTimeToBuyStocks3 {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int maxProfit = maxProfit(prices);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        int leftMin = prices[0];
        left[0] = 0; //no profit at day 1
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] - leftMin > left[i-1]) {
                left[i] = prices[i] - leftMin;
            }
            else {
                left[i] = left[i-1];
            }
            if (prices[i] < leftMin)
                leftMin = prices[i];
        }

        int rightMax = Math.max(prices[prices.length-1],prices[prices.length-2]);
        right[prices.length-1] = 0; // after index prices.length the profit zero.
        right[prices.length-2] = 0;
        for (int i = prices.length-3; i >=0; i--) {
            if (rightMax - prices[i+1] > right[i+1]) {
                right[i] = rightMax - prices[i+1];
            }
            else {
                right[i] = right[i+1];
            }
            if (prices[i+1] > rightMax)
                rightMax = prices[i+1];
        }

        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (left[i]+right[i] > maxProfit)
                maxProfit = left[i]+right[i];
        }
        return maxProfit;
    }
}
