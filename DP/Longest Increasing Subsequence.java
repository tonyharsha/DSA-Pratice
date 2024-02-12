//Recursion
//TC O(2^N)
//SC O(N).
class Solution {
    public int lengthOfLIS(int[] nums) {
        return solve(nums,0,-1);
        
    }

    public int solve(int[] nums,int index,int prev){
        if(index==nums.length) return 0;

          
        int inc=0;
        int exc=0;
        if(prev==-1 || nums[index]>nums[prev]){
            inc= 1+solve(nums,index+1,index);
        }
        exc= 0+solve(nums,index+1,prev);
        

        return Math.max(inc,exc);
    }
}


//Memoization
//TC O(N^2)
//SC O(N^2).
//Imp prev starting as -1 and handling it with +1 during the index .
class Solution {
 public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return solve(nums,0,-1,dp);
        
    }

    public int solve(int[] nums,int index,int prev,int dp[][]){
        if(index==nums.length) return 0;

        if(dp[index][prev+1]!=-1) return dp[index][prev+1];

        int inc=0;
        int exc=0;
		//IMP.
        if(prev==-1 || nums[index]>nums[prev]){
            inc= 1+solve(nums,index+1,index,dp);
        }
        exc= 0+solve(nums,index+1,prev,dp);
        

        return dp[index][prev+1]=Math.max(inc,exc);
    }
    
}

//Tabulation
//TC O(N^2)
//SC O(N^2)
//The second parameter goes with +1because second parameter prev starts with -1.

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,0));
       
        for(int index=n-1;index>=0;index--){
            for(int prev=index-1;prev>=-1;prev--){
                    int inc=0;
                    if(prev==-1 || nums[index]>nums[prev]){
                     //The second parameter goes with +1.
                     inc= 1+ dp[index+1][index+1];
                     }
                    //The second parameter goes with +1.
                    int exc= 0+ dp[index+1][prev+1];
            

                dp[index][prev+1]=Math.max(inc,exc);

            }
        }
        //return dp[0][-1+1];
        return dp[0][0];
        
    }
}


//Space optimization
//TC O(N^2)
//SC O(N).
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int curr[]=new int[n+1];
        int next[]=new int[n+1];

       
        for(int index=n-1;index>=0;index--){
            for(int prev=index-1;prev>=-1;prev--){
                    int inc=0;
                    if(prev==-1 || nums[index]>nums[prev]){
                     //The second parameter goes with +1.
                     inc= 1+ next[index+1];
                     }
                    //The second parameter goes with +1.
                    int exc= 0+ next[prev+1];
            

                curr[prev+1]=Math.max(inc,exc);

            }
            System.arraycopy(curr,0,next,0,curr.length);
        }
        return next[0];
    }
}

//Optimal Solution using Binary Search Lower bound concept.
//TC O(NlogN).
//SC O(N).
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res=new ArrayList<>();
        res.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]>res.get(res.size()-1)){
                res.add(nums[i]);
            }
            else{
				//get the index of just greater element.
                int index=getLowerBound(res,nums[i]);
                res.set(index,nums[i]);
            }
        }
        return res.size();
        
    }

    public int getLowerBound(List<Integer> res,int element){
        int index=-1;
        int start=0;
        int end=res.size()-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(res.get(mid)>=element){
                index=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return index;   
    }
}