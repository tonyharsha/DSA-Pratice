class Solution {
	//Recursive
    //TC O(M^N)
    //SC O(N)
    static long noOfWays(int M , int N , int X) {
        // code here
        return solve(M,N,X);
    }
    
    static long solve(int M,int N,int X){
        if(N==0 && X==0) return 1;
        if(N<0 ||X<0) return 0;
        
        long count=0;
        for(int i=1;i<=M;i++){
            count+=solve(M,N-1,X-i);
        }
        return count;
        
    }
    
    
    
	//Memoization
    //TC O(M*N*X)
    //SC O(N*X)
    static long noOfWays(int M , int N , int X) {
        // code here
        long dp[][]=new long[N+1][X+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return solve(M,N,X,dp);
    }
    
    static long solve(int M,int N,int X,long dp[][]){
        if(N==0 && X==0) return 1;
        if(N<0 ||X<0) return 0;
        
        if(dp[N][X]!=-1) return dp[N][X];
        
        long count=0;
        for(int i=1;i<=M;i++){
            count+=solve(M,N-1,X-i,dp);
        }
        return dp[N][X]=count;
        
    }

    
	//Tabulation
    //TC O(N*X*M)
    //SC O(N*X)
    static long noOfWays(int M , int N , int X) {
        // code here
        long dp[][]=new long[N+1][X+1];
        
        dp[0][0]=1;
        
        //N N->0
        //X X->0
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=X;j++){
                long count=0;
                for(int k=1;k<=M;k++){
                    if(j-k>=0)
                     count+=dp[i-1][j-k];
                }
                dp[i][j]=count;
            }
        }
        
        return dp[N][X];
    }
    
    
	//Space optimization
    //TC O(N*X*M)
    //SC O(X)
        static long noOfWays(int M , int N , int X) {
        // code here
        long curr[]=new long[X+1];
        long prev[]=new long[X+1];
        
        prev[0]=1;
        
        //N N->0
        //X X->0
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=X;j++){
                long count=0;
                for(int k=1;k<=M;k++){
                    if(j-k>=0)
                     count+=prev[j-k];
                }
                curr[j]=count;
            }
            System.arraycopy(curr,0,prev,0,curr.length);
        }
        
        return prev[X];
    }
    
    
    
};