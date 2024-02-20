class Solution{
    //Recursive
	//TC O(2^N)
	//SC O(N)
    static int equalPartition(int N, int arr[])
    {
        // code here
        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
		
		//We have converted the equalPartition sum to target sum.
		//The anolagy is equalPartition can be done only if totalSum is even and if totalSum/2 exists in subsets of array.
		//If totalsum is odd or totalSum/2 doesen't exists in subsets of array then we cant do equalPartition.
		//If total Sum is even then go to find the target sum in subsets of array.
        
        if(totalSum%2!=0)
          return 0;
        return (solve(0,arr,totalSum/2)==true)?1:0;
    }
    
    static boolean solve(int index,int arr[],int targetSum){
        if(index>=arr.length) return false;
        if(targetSum<0) return false;
        if(targetSum==0) return true;
        
        boolean pick=solve(index+1,arr,targetSum-arr[index]);
        boolean notpick=solve(index+1,arr,targetSum);
        
        return pick||notpick;
    }
    
    
    
    //Memoization
	//TC O(N*totalSum/2)~O(N*totalSum/2).
	//SC O(N*totalSum/2).
    static int equalPartition(int N, int arr[])
    {
        // code here
        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        
        if(totalSum%2!=0)
          return 0;
        int dp[][]=new int[N+1][totalSum/2+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        //return (solve(0,arr,totalSum/2,dp)==1)?1:0;
        return solve(0,arr,totalSum/2,dp);
    }
    
    static int solve(int index,int arr[],int targetSum,int dp[][]){
        if(index>=arr.length) return 0;
        if(targetSum<0) return 0;
        if(targetSum==0) return 1;
        
        if(dp[index][targetSum]!=-1) return dp[index][targetSum];
        
        int pick=solve(index+1,arr,targetSum-arr[index],dp);
        int notpick=solve(index+1,arr,targetSum,dp);
        
        return dp[index][targetSum]=pick|notpick;
    }
    
    
    
	//Tabulation
	//TC O(N*totalSum/2)~O(N*totalSum/2).
	//SC O(N*totalSum/2).
    static int equalPartition(int N, int arr[])
    {
        // code here
        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        
        if(totalSum%2!=0)
          return 0;
        int dp[][]=new int[N+1][(totalSum/2)+1];
        
        //Base case.
        for(int i=0;i<=N;i++){
            dp[i][0]=1;
        }
        
        for(int index=N-1;index>=0;index--){
            for(int targetSum=0;targetSum<=totalSum/2;targetSum++){
                
                int pick=0;
                if(targetSum-arr[index]>=0)
                    pick=dp[index+1][targetSum-arr[index]];
                int notpick=notpick=dp[index+1][targetSum];
        
                dp[index][targetSum]=pick|notpick;
                
            }
        }
        
        return dp[0][totalSum/2];
        
    }
    
    
	//Space Optimization.
	//TC O(N*totalSum/2)~O(N*totalSum/2).
	//SC O(totalSum/2).
    static int equalPartition(int N, int arr[])
    {
        // code here
        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        
        if(totalSum%2!=0)
          return 0;
        
        
        int curr[]=new int[(totalSum/2)+1];
        int next[]=new int[(totalSum/2)+1];
        
        //Base case.
        next[0]=1;
        curr[0]=1;
        
        
        for(int index=N-1;index>=0;index--){
            for(int targetSum=0;targetSum<=totalSum/2;targetSum++){
                
                int pick=0;
                if(targetSum-arr[index]>=0)
                    pick=next[targetSum-arr[index]];
                int notpick=notpick=next[targetSum];
        
                curr[targetSum]=pick|notpick;
                
            }
            System.arraycopy(curr,0,next,0,curr.length);
        }
        
        return curr[totalSum/2];
        
    }
    
    
}