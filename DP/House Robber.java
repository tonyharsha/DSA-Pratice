class Solution {
    //Recursion
    //TC O(2^N)
    //SC O(N) Recursion stack
    
    public int rob(int[] nums) {
        int n=nums.length;
        return rob(nums,n-1);  
    }

    public int rob(int nums[],int n){
        if(n<0) return 0;
        if(n==0) return nums[0];

        int include=nums[n]+rob(nums,n-2);
        int exclude=0+rob(nums,n-1);
        return Math.max(include,exclude);
    }
    

    //Memoization 
    //TC O(N)
    //SC O(N) Array+Recursion stack
    
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return rob(nums,n-1,dp);  
    }

    public int rob(int nums[],int n,int []dp){
        if(n<0) return 0;
        if(n==0) return nums[0];

        if(dp[n]!=-1) return dp[n];

        int include=nums[n]+rob(nums,n-2,dp);
        int exclude=0+rob(nums,n-1,dp);
        return dp[n]=Math.max(include,exclude);
    }
    

   //Tabulation
   //TC O(N)
   //SC O(N) Array+Recursion stack
   
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        if(n>1)
          dp[1]=Math.max(dp[0],nums[1]);

        for(int i=2;i<n;i++){
            int include=nums[i]+dp[i-2];
            int exclude=0+dp[i-1];
            dp[i]=Math.max(include,exclude);
        }

        return dp[n-1];
    }
    
    //Space Optimization
    //TC O(N)
    //Sc O(1)
     public int rob(int[] nums) {
        int n=nums.length;
        int prev2=0;
        int prev1=nums[0];
        for(int i=1;i<n;i++){
            int include=nums[i]+prev2;
            int exclude=0+prev1;
            prev2=prev1;
            prev1=Math.max(include,exclude);
        }
        return prev1;
    }


}