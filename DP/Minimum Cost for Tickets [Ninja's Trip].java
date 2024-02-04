import java.util.*;

//Recursive solution.
//TC Exponential O(3^N)
//SC Recursion stack
public class Solution {

	public static int minimumCoins(int n, int[] days, int[] cost) {
	
		//Write your code here	
		return minimumCoins(n,days,cost,0);

	}
	
	public static int minimumCoins(int n,int []days,int [] cost,int index){
		if(index>=n) return 0;

		//option 1.
		int opt1= cost[0]+minimumCoins(n,days,cost,index+1);

		//option 2.
		int i;
		for(i=index;i<n && days[i]<days[index]+7;i++);

		int opt2= cost[1]+minimumCoins(n,days,cost,i);

		//option 3.
		int j;
		for(j=index;j<n && days[j]<days[index]+30;j++);
		int opt3= cost[2]+minimumCoins(n,days,cost,j);


		return Math.min(opt1,Math.min(opt2,opt3));
	}

}




//Memoization
//TC O(N)
//SC O(N)
public class Solution {

	public static int minimumCoins(int n, int[] days, int[] cost) {
	
		int dp[]=new int[n+1];
        
		Arrays.fill(dp,-1);
		minimumCoins(n,days,cost,0,dp);
		return dp[0];
		 

	}

	public static int minimumCoins(int n,int []days,int[] cost,int index,int[] dp){
		if(index>=n) return 0;

		if(dp[index]!=-1) return dp[index];
		//option 1
		int opt1=cost[0]+minimumCoins(n,days,cost,index+1,dp);
		//option 2
		int i;
		for(i=index;i<n && days[i]<days[index]+7;i++);
		int opt2=cost[1]+minimumCoins(n,days,cost,i,dp);

		//option 3
		int j;
		for(j=index;j<n && days[j]<days[index]+30;j++);
		int opt3=cost[2]+minimumCoins(n,days,cost,j,dp);

		return dp[index]=Math.min(opt1,Math.min(opt2,opt3));
	}

}


//Tabulation
//TC O(N)
//SC O(N)
public class Solution {

	public static int minimumCoins(int n, int[] days, int[] cost) {
	
		int dp[]=new int[n+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		dp[n]=0;

		for(int k=n-1;k>=0;k--){
			//option 1
			int opt1=cost[0]+dp[k+1];
			//option 2
			int i;
			for(i=k;i<n && days[i]<days[k]+7;i++);
			int opt2=cost[1]+dp[i];

			//option 3
			int j;
			for(j=k;j<n && days[j]<days[k]+30;j++);
			int opt3=cost[2]+dp[j];

			dp[k]=Math.min(opt1,Math.min(opt2,opt3));
		}	

		return dp[0];		
	}

}

