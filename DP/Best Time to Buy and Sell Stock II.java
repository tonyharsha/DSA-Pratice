//Recursive
//TC O(2^N)
//SC O(N)
class Solution {
    public int maxProfit(int[] prices) {
        return solve(0,1,prices);
    }

    public int solve(int index,int buy,int prices[]){
        if(index==prices.length) return 0;

        int ans=0;
        if(buy==1){
            int buyKaro= -prices[index]+solve(index+1,0,prices);
            int ignoreKaro= 0+solve(index+1,1,prices);
            ans=Math.max(buyKaro,ignoreKaro);
        }else{
            int sellKaro= prices[index]+solve(index+1,1,prices);
            int ignoreKaro=0+solve(index+1,0,prices);
            ans=Math.max(sellKaro,ignoreKaro);
        }
        return ans;
    }
}



//Memoization
//TC O(N)
//SC O(N)
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n+1][2];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return solve(0,1,prices,dp);
    }

    public int solve(int index,int buy,int prices[],int dp[][]){
        if(index==prices.length) return 0;

        if(dp[index][buy]!=-1) return dp[index][buy];

        int ans=0;
        if(buy==1){
            int buyKaro= -prices[index]+solve(index+1,0,prices,dp);
            int ignoreKaro= 0+solve(index+1,1,prices,dp);
            ans=Math.max(buyKaro,ignoreKaro);
        }else{
            int sellKaro= prices[index]+solve(index+1,1,prices,dp);
            int ignoreKaro=0+solve(index+1,0,prices,dp);
            ans=Math.max(sellKaro,ignoreKaro);
        }
        return dp[index][buy]=ans;
    }
}



//Tabulation
//TC O(N)
//SC O(N)
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n+1][2];
        
        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<2;buy++){
                int ans=0;
                if(buy==1){
                    int buyKaro= -prices[index]+dp[index+1][0];
                    int ignoreKaro= 0+dp[index+1][1];
                    ans=Math.max(buyKaro,ignoreKaro);
                }else{
                    int sellKaro= prices[index]+dp[index+1][1];
                    int ignoreKaro=0+dp[index+1][0];
                    ans=Math.max(sellKaro,ignoreKaro);
                }
                dp[index][buy]=ans;
            }
        }

        return dp[0][1];
    }
}


//Space optimization
//TC O(N)
//SC O(4)~O(1).
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int next[]=new int[2];
        int curr[]=new int[2];
        
        for(int index=n-1;index>=0;index--){
            for(int buy=0;buy<2;buy++){
                int ans=0;
                if(buy==1){
                    int buyKaro= -prices[index]+next[0];
                    int ignoreKaro= 0+next[1];
                    ans=Math.max(buyKaro,ignoreKaro);
                }else{
                    int sellKaro= prices[index]+next[1];
                    int ignoreKaro=0+next[0];
                    ans=Math.max(sellKaro,ignoreKaro);
                }
                curr[buy]=ans;
            }
            System.arraycopy(curr,0,next,0,curr.length);
        }

        return curr[1];
    }
}



//Space optimization Single pass
//TC O(N)
//SC O(1).
class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int min=prices[0];
        int n=prices.length;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]) continue;
            ans+=(prices[i-1]-min);
            min=prices[i];
        }
        
        ans+=prices[n-1]-min;
        return ans;
        
    }
}

//Question link https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
