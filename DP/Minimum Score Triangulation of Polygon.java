//recursion
//TC exponential O(N^3)
//SC Recursion stack   O(N^3) + Memoization tsble O(N^2).
class Solution {
    public int minScoreTriangulation(int[] values) {
        int start=0;
        int end=values.length-1;
        return solve(values,start,end);

    }

    public int solve(int values[],int start,int end){
        if(start+1==end) return 0;

        int ans=Integer.MAX_VALUE;
        for(int k=start+1;k<end;k++){
            ans=Math.min(ans,values[start]*values[end]*values[k]+solve(values,start,k)+solve(values,k,end));
        }
        return ans;
    }
}


//Memoization
//Top down approach
//TC O(N^3)
//SC O(N^2)
class Solution {
    public int minScoreTriangulation(int[] values) {
        int start=0;
        int end=values.length;
        int dp[][]=new int[end][end];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return solve(values,start,end-1,dp);
        
    }


     public int solve(int values[],int start,int end,int dp[][]){
        if(start+1==end) return 0;

        if(dp[start][end]!=-1) return dp[start][end];
        int ans=Integer.MAX_VALUE;
        for(int k=start+1;k<end;k++){
            ans=Math.min(ans,values[start]*values[end]*values[k]+solve(values,start,k,dp)+solve(values,k,end,dp));
        }
        return dp[start][end]= ans;
    }
}


//Tabulation
//Bottom up approach
//Just reverse to above approach.
//O(N^3)
//O(N^2)
class Solution {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int dp[][]=new int[n][n];
        
        //Intilially in top down approach we used to start from 0 to n-1.
        //Since it is bottom up we are starting from n-1 to i+2.
        //here we took j=i+2 because if j=i then both are pointinh to same node no triangle will be formed
        // if j=i+1 then it our base case triangle can not be formed by two points do i+2 will have three points
        //there is a scope for triangle. 
        for(int i=n-1;i>=0;i--){
            for(int j=i+2;j<n;j++){
                int ans=Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                 ans=Math.min(ans,values[i]*values[j]*values[k]+dp[i][k]+dp[k][j]);
                }
               dp[i][j]=ans;
            }
        }

        //In top dowm we started from dp[0][n-1]
        //In bottom up we will end at dp[0][n-1]
        //Hence return dp[0][n-1]
        return dp[0][n-1];
    }
}