class Solution {

    //Recursive.
    //TC O(N!)
    //Sc O(N)
    public int getMoneyAmount(int n) {
        return solve(1,n);
    }

    public int solve(int start,int end){
        if(start>=end) return 0;

        int ans=Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            ans=Math.min(ans,i+Math.max(solve(start,i-1),solve(i+1,end)));
        }
        return ans;
    }


    //Memoization
    //TC O(N^2)
    //SC O(N^2)
    public int getMoneyAmount(int n) {
        int dp[][]=new int[n+1][n+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return solve(1,n,dp);
    }

    public int solve(int start,int end,int dp[][]){
        if(start>=end) return 0;
        
        if(dp[start][end]!=-1) return dp[start][end];
        int ans=Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            ans=Math.min(ans,i+Math.max(solve(start,i-1,dp),solve(i+1,end,dp)));
        }
        return dp[start][end]=ans;
    }


    //Tabulation
    //TC O(N^3)
    //SC O(N^2)
    public int getMoneyAmount(int n) {
        int dp[][]=new int[n+2][n+2];
        for(int start=n;start>=1;start--){
            for(int end=start;end<=n;end++){
                if(start==end) continue;
                int ans=Integer.MAX_VALUE;
                for(int i=start;i<=end;i++){
                    ans=Math.min(ans,i+Math.max(dp[start][i-1],dp[i+1][end]));
                }
                dp[start][end]=ans;
            }
        }
        return dp[1][n];
    }

   
}

//Question Link: https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/