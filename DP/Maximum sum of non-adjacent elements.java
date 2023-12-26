import java.util.* ;
import java.io.*; 
import java.util.*;
//Recursion.
//TC O(2^N)
//Sc O(N) Recursion stack.

public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n=nums.size()-1;
		return maximumNonAdjacentSum(nums,n);
	}

	public static int maximumNonAdjacentSum(ArrayList<Integer> nums,int n){
		if(n<0) return 0;
		if(n==1) return nums.get(n);
		
		int include=nums.get(n)+maximumNonAdjacentSum(nums,n-2);
		int exclude=0+maximumNonAdjacentSum(nums,n-1);
		return Math.max(include,exclude);
	}
}


//Memoization
//TC O(N)
//SC O(N) Array+ Recursion stack

public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n=nums.size()-1;
		int dp[]=new int[n+1];
		Arrays.fill(dp,-1);
		return maximumNonAdjacentSum(nums,n,dp);
		
	}

	public static int maximumNonAdjacentSum(ArrayList<Integer> nums,int n,int dp[]){
		if(n==0) return nums.get(n);
		if(n<0) return 0;
		
		if(dp[n]!=-1) return dp[n];
		int includesum=nums.get(n)+maximumNonAdjacentSum(nums,n-2,dp);
		int excludesum=0+maximumNonAdjacentSum(nums,n-1,dp);
		return dp[n]= Math.max(includesum,excludesum);
	}
}


//Tabulation
//TC O(N)
//SC O(N) Array +Recursion stack.

public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n=nums.size();
		int dp[]=new int[n];
		Arrays.fill(dp,-1);
		dp[0]=nums.get(0);
		if(n>1)
		 dp[1]=Math.max(dp[0],nums.get(1));

		for(int i=2;i<n;i++){
			int include=nums.get(i)+dp[i-2];
			int exclude=0+dp[i-1];
			dp[i]=Math.max(include,exclude);
		}

		return dp[n-1];
		
	}
}

//space optimization
//TC O(N)
//SC O(1)
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n=nums.size();
		int prev1=nums.get(0);
		int prev2=0;

		for(int i=1;i<n;i++){
			int include=nums.get(i)+prev2;
			int exclude=0+prev1;
			prev2=prev1;
			prev1=Math.max(include,exclude);
		}

		return prev1;
		
	}
}



