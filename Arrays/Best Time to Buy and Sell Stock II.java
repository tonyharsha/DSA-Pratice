class Solution {
    //TC O(N)
    //SC O(1)
    //Buy and sell Multiple times.
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}