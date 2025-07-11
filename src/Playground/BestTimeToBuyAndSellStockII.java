package Playground;

public class BestTimeToBuyAndSellStockII {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length == 1){
                return 0;
            }

            int result = 0;

            int buy = prices[0];

            for(int i=1; i<prices.length; i++){
                if(prices[i] > buy){
                    result += (prices[i] - buy);
                }
                buy = prices[i];

            }

            return result;
        }
    }
}
