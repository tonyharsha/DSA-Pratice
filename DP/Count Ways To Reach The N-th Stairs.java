import java.util.* ;
import java.io.*; 
public class Solution {
	//TC O(n)
	//SC O(n)
	public static int countDistinctWayToClimbStair(long nStairs) {
		// Write your code here.
       if (nStairs <= 1) {
            return 1;
        }

		// Write your code here.

		long[] dp= new long[(int)(nStairs+1)];
		int mod=1000000007;
		dp[0]=1;
		dp[1]=1;

		for(int i=2;i<=nStairs;i++){
		dp[i]=((dp[i-1]%mod)+(dp[i-2]%mod))%mod;
		}
	
		return (int)dp[(int)nStairs];
	}
}