class Solution {
    //Recursive.
    //TC O(N^3)
    //SC O(N)
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                ans=Math.max(ans,2+solve(i,nums[j]-nums[i],nums));
            }
        }
        return ans;
        
    }

    public int solve(int start,int diff,int nums[]){
        if(start<0) return 0;

        int res=0;
        for(int index=start-1;index>=0;index--){
            if(nums[start]-nums[index]==diff){
                res=Math.max(res,1+solve(index,diff,nums));
            }
        }
        return res;
    }
    
    
    
    //Memoization
    //TC O(N^3)
    //SC O(N^2).
    //The space complexity of the array of HashMaps is O(n), and each HashMap may store O(n) entries in the worst case
    // the overall space complexity is O(n^2)
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;


        
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dp[]=new int[n+1];
                Arrays.fill(dp,-1);
                ans=Math.max(ans,2+solve(i,nums[j]-nums[i],nums,dp));
            }
        }
        return ans;
        
    }

    public int solve(int start,int diff,int nums[],int dp[]){
        if(start<0) return 0;

        if (dp[start]!=-1) return dp[start];
        int res=0;
        for(int index=start-1;index>=0;index--){
            if(nums[start]-nums[index]==diff){
                res=Math.max(res,1+solve(index,diff,nums,dp));
            }
        }
        return dp[start]=res;
    }

    

    
    //Memoization
    //TC O(N^3)
    //SC O(N^2)
    //The space complexity of the array of HashMaps is O(n), and each HashMap may store O(n) entries in the worst case
    // the overall space complexity is O(n^2)
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;

       HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap<>();
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                ans=Math.max(ans,2+solve(i,nums[j]-nums[i],nums,dp));
            }
        }
        return ans;
        
    }

    public int solve(int start,int diff,int nums[], HashMap<Integer,Integer> dp[]){
        if(start<0) return 0;

        if(dp[start].containsKey(diff)) return dp[start].get(diff);
        int res=0;
        for(int index=start-1;index>=0;index--){
            if(nums[start]-nums[index]==diff){
                res=Math.max(res,1+solve(index,diff,nums,dp));
            }
        }
        dp[start].put(diff,res);
        return res;
    }
    

    //Tabulation
    //TC O(N^2)
    //SC O(N^2) It is less than O(N^2) like >O(N) and <O(N^2)
    //The space complexity of the array of HashMaps is O(n), and each HashMap may store O(n) entries in the worst case
    // the overall space complexity is O(n^2) 
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
      
       //One index can have multiple diff with respective length.
       //dp[i].get(diff) gives me the length of incresing arthmetic sequence till that index with difference diff.
       HashMap<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap<>();
        }
        
        int ans=0;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int diff=nums[i]-nums[j];
                int count=1;
                
                //If diff exists at jth index then get that count..
                if(dp[j].containsKey(diff)) count=dp[j].get(diff);

                //if diff exists then add 1 to it else 
                //also we are adding 1 becuase this will consider both {arr[i],arr[j]} as 1 sequence 
                //therefore length should be 2 so we are adding 1 even if diff doesn't exists in jth index. 
                dp[i].put(diff,1+count);
                ans=Math.max(ans,dp[i].get(diff));
            }
        }

        return ans;
        
    }
}