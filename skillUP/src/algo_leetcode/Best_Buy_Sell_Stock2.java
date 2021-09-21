package algo_leetcode;

public class Best_Buy_Sell_Stock2 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int temp = 0;

//        for(int i = 0; i < prices.length; i++) {
//            if(i > 0) {
//                if(prices[i-1] > prices[i]) {
//                    profit += prices[i-1] - temp;
//                    temp = prices[i];
//                }
//
//                if(i == prices.length-1) {
//                    profit += prices[i] - temp;
//                }
//            } else {
//                temp = prices[i];
//            }
//        }

        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] > prices[i-1])
            {
                profit += prices[i] - prices[i-1];
            }
        }

        System.out.println(profit);
        return profit;
    }
}
