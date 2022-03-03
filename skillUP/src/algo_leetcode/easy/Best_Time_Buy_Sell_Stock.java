package algo_leetcode.easy;

public class Best_Time_Buy_Sell_Stock {
    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {2,4,1};

        maxProfit(prices);
    }

    public static int maxProfit(int[] prices) {
        int maxStock = 0;
        int minStock = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {
            maxStock = Math.max(maxStock, prices[i]);
            if(minStock > prices[i]) {
                maxStock = 0;
                minStock = prices[i];
            }
            maxProfit = Math.max(maxStock - minStock, maxProfit);
        }
        System.out.println(maxProfit);
        return maxProfit;
    }
}
