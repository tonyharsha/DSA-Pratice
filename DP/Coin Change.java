//Recursion
//TC O(m^n)  m=amount n=size of coins array.
//SC O(1)

class Solution {
    public int coinChange(int[] coins, int amount) {
        int result=coinChangeSolve(coins,amount);
        return (result==Integer.MAX_VALUE)?-1:result;
    }

    public int coinChangeSolve(int [] coins,int amount){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;

        int minimum=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int ans=coinChangeSolve(coins,amount-coins[i]);
            if(ans!=Integer.MAX_VALUE){
                minimum=Math.min(minimum,1+ans);
            }
        }

        return minimum;

       
    }
}

//Memoization
//TC O(M*N)
//SC O(M)  M=amount.

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,-1);
        int result=coinChangeSolve(coins,amount,dp);
        return (result==Integer.MAX_VALUE)?-1:result;
    }

    public int coinChangeSolve(int [] coins,int amount,int dp[]){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;

        if (dp[amount]!=-1) return dp[amount];

        int minimum=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int ans=coinChangeSolve(coins,amount-coins[i],dp);
            if(ans!=Integer.MAX_VALUE){
                minimum=Math.min(minimum,1+ans);
            }
        }

        return dp[amount]=minimum;

       
    }
}

//Tabulation
//TC O(M*N)
//SC O(M)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if((i-coins[j]>=0)&&(dp[i-coins[j]]!=Integer.MAX_VALUE))
                   dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
            }
        }

        return (dp[amount]==Integer.MAX_VALUE)?-1:dp[amount];
    }
}