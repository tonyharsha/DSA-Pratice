class Solution
{ 
    //Recursion
	//TC O(2^N).
	//SC recursion satck 
    public int MinSquares(int n)
    {
        return Recurve(n);
    }
    
    public int Recurve(int n){
        if(n==0) return 0;
        
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            min=Math.min(min,Recurve(n-i*i));
        }
        
        return min+1;
    }
    */
    
    //Memoization
    // TC O(n * sqrt(n))
	// SC O(N)
    public int MinSquares(int n)
    {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return Recurve(n,dp);
    }
    
    public int Recurve(int n,int dp[]){
        if(n==0) return 0;
        
        if(dp[n]!=-1) return dp[n];
        
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            min=Math.min(min,Recurve(n-i*i,dp));
        }
        
        return dp[n]=min+1;
    }
    
    
    //Tabulation
	// TC O(n * sqrt(n))
	// SC O(N)
    public int MinSquares(int n)
    {
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        
        for(int i=2;i<=n;i++){
            int res=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                res=Math.min(res,dp[i-j*j]);
            }
            dp[i]=res+1;
        }
        return dp[n];
    }
    
    
}