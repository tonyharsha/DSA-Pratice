import java.util.*;
public class Solution {
	static int MOD=1000000007;
    //Recursion
	//TC O(2^N)
	//SC Recursion stack.
	
	public static long countDerangements(int n) {
		// Write your code here.
		if(n==1) return 0;
		if(n==2) return 1;

		//(n-1)*(countDerangements(n-1)+countDerangements(n-2));
		return ((n-1)%MOD)*((countDerangements(n-1)%MOD)+(countDerangements(n-2)%MOD))%MOD;
	}
	


    //Memoization
	//TC O(N)
	//SC Recursion stack.
	
	public static long countDerangements(int n) {
		long dp[]=new long[n+1];
		Arrays.fill(dp,-1);
		return Memo(n,dp);
	}

	public static long Memo(int n,long dp[]){
		if(n==1) return 0;
		if(n==2) return 1;

		if(dp[n]!=-1) return dp[n];

		return dp[n]= ((n-1)%MOD)*((Memo(n-1,dp)%MOD)+(Memo(n-2,dp)%MOD))%MOD;
	}
	

	//Tabulation
	//TC O(N)
	//SC Recursion stack.
	
	public static long countDerangements(int n) {
		long dp[]=new long[n+1];
		dp[1]=0;
		dp[2]=1;
		for(int i=3;i<=n;i++){
			dp[i]=((i-1)%MOD)*((dp[i-1]%MOD)+(dp[i-2]%MOD))%MOD;
		}
		return dp[n];
	}
	

	// space optimization.
	//TC O(N)
	//SC O(1).
    public static long countDerangements(int n) {
		long prev2=0;
		long prev1=1;
		for(int i=3;i<=n;i++){
			long res=((i-1)%MOD)*((prev1%MOD)+(prev2%MOD))%MOD;
			prev2=prev1;
			prev1=res;
		}
		return prev1;
	}
	
}