package Playground;

public class BestTimeBuySellStock {
    class Solution {
        public int maxProfit(int[] prices) {

            int result = 0;

            if(prices.length==1){
                return 0;
            }

            int buy = -1;

            for(int i=0; i<prices.length; i++){
                int curr = prices[i];

                if(buy != -1){
                    if(curr < buy){
                        buy = curr;
                    }else if(curr > buy){
                        int profit = curr - buy;
                        result = result < profit ? profit : result;
                    }
                }else{
                    buy = curr;
                }
            }

            return result;
        }
    }
}
