class Solution {
    
	//Recursive.
	//TC O(2^N)
	//SC O(N)
    public int minSwap(int[] nums1, int[] nums2) {
       // return Math.min(solve(nums1,nums2,0,0),solve(nums1,nums2,0,1));
        returm solve(nums1,nums2,0,0);
    }

    public int solve(int nums1[],int nums2[],int index,int swap){
        if(index==nums1.length) return 0;

        int prev1;
        int prev2;
		//since we are comparing with previous index to handel array out of bound exception.
        if(index==0){
            prev1=-1;
            prev2=-1;
        }else{
            prev1=nums1[index-1];
            prev2=nums2[index-1];
        }

        //catch 
		//Very imp Here we are not actually swapping the array elements 
		//We are swapping the previous values based on swap parameter.
		//1 indicates swap has to preformed to compare the values. 0 indicates no swap to be performed.
        if(swap==1){
            int temp=prev1;
            prev1=prev2;
            prev2=temp;
        }
		
        int ans=Integer.MAX_VALUE;
        //no swap case.
        if(nums1[index]>prev1 && nums2[index]>prev2){
            ans=solve(nums1,nums2,index+1,0);
        }

        //swap case.
        if(nums1[index]>prev2 && nums2[index]>prev1){
            ans=Math.min(ans,1+solve(nums1,nums2,index+1,1));
        }

        return ans;

    }
    

    
	//Memoization
	//TC O(N*2) ~ O(N).
	//SC O(N).
    public int minSwap(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int dp[][]=new int[n+1][2];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        //return Math.min(solve(nums1,nums2,0,0,dp),solve(nums1,nums2,0,1,dp));
        return solve(nums1,nums2,0,0,dp);
    }

    public int solve(int nums1[],int nums2[],int index,int swap,int dp[][]){
        if(index==nums1.length) return 0;

        if(dp[index][swap]!=-1) return dp[index][swap];

        int prev1;
        int prev2;
        if(index==0){
            prev1=-1;
            prev2=-1;
        }else{
            prev1=nums1[index-1];
            prev2=nums2[index-1];
        }

        //catch 
        if(swap==1){
            int temp=prev1;
            prev1=prev2;
            prev2=temp;
        }
        int ans=Integer.MAX_VALUE;
        //no swap case.
        if(nums1[index]>prev1 && nums2[index]>prev2){
            ans=solve(nums1,nums2,index+1,0,dp);
        }

        //swap case.
        if(nums1[index]>prev2 && nums2[index]>prev1){
            ans=Math.min(ans,1+solve(nums1,nums2,index+1,1,dp));
        }

        return dp[index][swap]=ans;

    }
    

    //Tabulation
	//TC O(N)
	//SC O(N).
    public int minSwap(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int dp[][]=new int[n+1][2];

        for(int index=n-1;index>=0;index--){
            for(int swap=1;swap>=0;swap--){

                int prev1;
                int prev2;
                if(index==0){
                    prev1=-1;
                    prev2=-1;
                }else{
                    prev1=nums1[index-1];
                    prev2=nums2[index-1];
                }

                //catch 
                if(swap==1){
                    int temp=prev1;
                    prev1=prev2;
                    prev2=temp;
                }
                int ans=Integer.MAX_VALUE;
                //no swap case.
                if(nums1[index]>prev1 && nums2[index]>prev2){
                    ans=dp[index+1][0];
                }

                //swap case.
                if(nums1[index]>prev2 && nums2[index]>prev1){
                    ans=Math.min(ans,1+dp[index+1][1]);
                }

                dp[index][swap]=ans;

            }
        }

        return dp[0][0];
        
    }
    

    //Space optimization
	//TC O(N)
	//SC O(2) ~ O(1).
    public int minSwap(int[] nums1, int[] nums2) {
        int n=nums1.length;

        int next[]=new int[2];
        int curr[]=new int[2];

        for(int index=n-1;index>=0;index--){
            for(int swap=1;swap>=0;swap--){

                int prev1;
                int prev2;
                if(index==0){
                    prev1=-1;
                    prev2=-1;
                }else{
                    prev1=nums1[index-1];
                    prev2=nums2[index-1];
                }

                //catch 
                if(swap==1){
                    int temp=prev1;
                    prev1=prev2;
                    prev2=temp;
                }
                int ans=Integer.MAX_VALUE;
                //no swap case.
                if(nums1[index]>prev1 && nums2[index]>prev2){
                    ans=next[0];
                }

                //swap case.
                if(nums1[index]>prev2 && nums2[index]>prev1){
                    ans=Math.min(ans,1+next[1]);
                }

                curr[swap]=ans;

            }

            System.arraycopy(curr,0,next,0,curr.length);
        }

        return curr[0];
        
    }

    
}