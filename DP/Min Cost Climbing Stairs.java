//RECURSION
//TC O(2^n)
//SC O(n) Recursion Stack.

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //F(n)=MIN(F(n-1),F(n-2))
        //F(0->n-1) =MIN(F(n-1),F(n-2))+Cost[n];
        

        int n=cost.length;
        return Math.min(minCostClimbingStairs(cost,n-1),minCostClimbingStairs(cost,n-2));
    }

    public int minCostClimbingStairs(int [] cost,int n){
        //BASE CASE
        if(n==0) return cost[0];
        if(n==1) return cost[1];

        return Math.min(minCostClimbingStairs(cost,n-1),minCostClimbingStairs(cost,n-2))+cost[n];
    }
}


//Memoization
//TC O(n)
//SC O(n).

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //F(n)=MIN(F(n-1),F(n-2))
        //F(0->n-1) =MIN(F(n-1),F(n-2))+Cost[n];
        

        int n=cost.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(minCostClimbingStairs(cost,n-1,dp),minCostClimbingStairs(cost,n-2,dp));
    }

    public int minCostClimbingStairs(int [] cost,int n,int dp[]){
        //BASE CASE
        if(n==0) return dp[n]= cost[0];
        if(n==1) return dp[n]= cost[1];

        if(dp[n]!=-1) return dp[n];

        return dp[n]=Math.min(minCostClimbingStairs(cost,n-1,dp),minCostClimbingStairs(cost,n-2,dp))+cost[n];
    }
}


//Tabulation Bottom up approach.
//TC O(n)
//SC O(n).

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //F(n)=MIN(F(n-1),F(n-2))
        //F(0->n-1) =MIN(F(n-1),F(n-2))+Cost[n];
        

        int n=cost.length;
        int dp[]=new int[n+1];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<n;i++){
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
        }

        return Math.min(dp[n-1],dp[n-2]);
    }

}


//Space Optimization.
//TC O(n)
//SC O(1).
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //F(n)=MIN(F(n-1),F(n-2))
        //F(0->n-1) =MIN(F(n-1),F(n-2))+Cost[n];
        

        int n=cost.length;
        int twostepback=cost[0];
        int onestepback=cost[1];
        int res=0;
        for(int i=2;i<n;i++){
            res=cost[i]+Math.min(onestepback,twostepback);
            twostepback=onestepback;
            onestepback=res;
        }
        return Math.min(onestepback,twostepback);
    }

}