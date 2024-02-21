class Solution {
    
    //Recursion
    //TC  O(N^2)
    //SC O(N)
    public int numTrees(int n) {
        return solve(n);
    }

    public int solve(int n){
        if(n<=1) return 1;
        
        int ans=0;
        //considering i as root.
        for(int i=1;i<=n;i++){
            ans+=solve(i-1)*solve(n-i);
        }

        return ans;


    }
    

    
    //Memoization
    //TC O(N^2)
    //SC O(N)
    public int numTrees(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }

    public int solve(int n,int dp[]){
        if(n<=1) return 1;

        if (dp[n]!=-1) return dp[n];
        
        int ans=0;
        //considering i as root.
        for(int i=1;i<=n;i++){
            ans+=solve(i-1,dp)*solve(n-i,dp);
        }

        return dp[n]=ans;


    }
    
    
    //Tabulation
    //TC O(N^2)
    //SC O(N)
    public int numTrees(int n) {
        int dp[]=new int[n+1];

        dp[0]=1;
        dp[1]=1;

        // i -> no of nodes.
        for(int i=2;i<=n;i++){
           int ans=0;
           //j -> conisdering head node.
           for(int j=1;j<=i;j++){
             ans+=dp[j-1]*dp[i-j];
           }
           dp[i]=ans;
        }

        return dp[n];

        

    }


    //This is same as finding the nth Catalan Number.
    //Catalan Sereies 1 1 2 5 14 42 132 429 1430 4862
    //         index  0 1 2 3 4  5  6   7   8    9.
	
	
	//Question Link :https://leetcode.com/problems/unique-binary-search-trees/description/

}