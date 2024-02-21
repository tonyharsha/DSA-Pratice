class Solution {
    //This question can be solved via 
    //->Longest Increasing Subsequent logic with small modification.
    //->DP + Hashing.
 
    //Recursive LIS
    //TC O(2^N)
    //SC O(N)
    public int longestSubsequence(int[] nums, int diff) {
        int ans=solve(0,-1,nums,diff);
        return ans;
        
    }

    public int solve(int index,int prevIndex,int nums[],int diff){
        if(index>=nums.length) return 0;
        int pick=0;
        int notpick=0;
        if(prevIndex==-1 || nums[index]-nums[prevIndex]==diff){
            pick=1+solve(index+1,index,nums,diff);
        }

        notpick=0+solve(index+1,prevIndex,nums,diff);

        return Math.max(pick,notpick);
    }


    //Memoziation LIS
    //TC O(N*N)
    //SC O(N*N)
    //Memory Limit Exceeded.
    public int longestSubsequence(int[] nums, int diff) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        int ans=solve(0,-1,nums,diff,dp);
        return ans;
        
    }

    public int solve(int index,int prevIndex,int nums[],int diff,int dp[][]){
        if(index>=nums.length) return 0;
        
        if(dp[index][prevIndex+1]!=-1) return dp[index][prevIndex+1];
        int pick=0;
        int notpick=0;
        if(prevIndex==-1 || nums[index]-nums[prevIndex]==diff){
            pick=1+solve(index+1,index,nums,diff,dp);
        }

        notpick=0+solve(index+1,prevIndex,nums,diff,dp);

        return dp[index][prevIndex+1]= Math.max(pick,notpick);
    }


    //Tabulation LIS
    //TC O(N^2)
    //SC O(N^2)
    //We used index+1 and prevIndex+1 because in earlier sol we have precheck for prevIndex
    //But in this we dont have therefore we are doing this.
    //Memory Limit Exceeded.

    public int longestSubsequence(int[] nums, int diff) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        
        for(int index=n-1;index>=0;index--){
            for(int prevIndex=index-1;prevIndex>=-1;prevIndex--){
                int pick=0;
                int notpick=0;
                if(prevIndex==-1 || nums[index]-nums[prevIndex]==diff){
                    pick=1+dp[index+1][index+1];
                }

                notpick=0+dp[index+1][prevIndex+1];
                
                dp[index][prevIndex+1]=Math.max(pick,notpick);
            }
        }

        return dp[0][-1+1];
        
    }



    //Space optimization LIS
    //TC O(N^2)
    //SC O(N)
    //Time Limit Exceeded.
    public int longestSubsequence(int[] nums, int diff) {
        int n=nums.length;

        int next[]=new int[n+1];
        int curr[]=new int[n+1];
        
        for(int index=n-1;index>=0;index--){
            for(int prevIndex=index-1;prevIndex>=-1;prevIndex--){
                int pick=0;
                int notpick=0;
                if(prevIndex==-1 || nums[index]-nums[prevIndex]==diff){
                    pick=1+next[index+1];
                }

                notpick=0+next[prevIndex+1];
                
                curr[prevIndex+1]=Math.max(pick,notpick);
            }
            System.arraycopy(curr,0,next,0,curr.length);
        }

        return curr[0];
        
    }

    //Using DP + Hashing 
    //use the logic of Longest Arithmetic Subsequence
    //TC O(N^2)
    //SC O(N^2)
    //Time Limit Exceed.
    public int longestSubsequence(int[] nums, int diff) {
        int n=nums.length;
       //One index can have multiple diff with respective length.
       //dp[i].get(diff) gives me the length of incresing arthmetic sequence till that index with difference diff.
       HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap<>();
        }
         int ans=0;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]-nums[j]!=diff)  continue;
                int count=1;

                if(dp[j].containsKey(diff)) count=dp[j].get(diff);

                dp[i].put(diff,1+count);
                ans=Math.max(ans,dp[i].get(diff));
            }
        }

        return (ans==0)?1:ans;
    }



    //Linear Traversal dp + Hashing.
    //Single Pass.
    //TC O(N)
    //SC O(N).
	//Accepted Solution.
    public int longestSubsequence(int[] nums, int diff) {
        int n=nums.length;
        int ans=0;
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<n;i++){
            int count=0;
            if(hm.containsKey(nums[i]-diff)){
                count=hm.get(nums[i]-diff);
            }
            hm.put(nums[i],count+1);
            ans=Math.max(ans,hm.get(nums[i]));

        }

        return ans;
        
    }


}

//Question Link : https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/