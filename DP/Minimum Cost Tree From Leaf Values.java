
//Merge Interval Pattern.
//0----i----n
//i=solve(0,i) some action solve(i+1,n)..
//Recursive
//TC O(N^3)
//SC O(N)
class Solution {
    public int mctFromLeafValues(int[] arr) {
        return solve(0,arr.length-1,arr);
        
    }

    public int solve(int start,int end,int arr[]){
        if(start==end) return 0;
        int ans=Integer.MAX_VALUE;

            //j should be less than n because for last element we will not able to calculate because j+1 will not be present.
			//Hence we loop till last second element and this will include last element as part of right sub part.
            for(int j=start;j<end;j++){
                ans=Math.min(ans,(getmax(start,j,arr)*getmax(j+1,end,arr)+solve(start,j,arr)+solve(j+1,end,arr)));
            }
        return ans;

    }

    public int getmax(int start,int end,int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}


//Memoization 
//TC O(N^3)
//SC O(N^2)
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n+1][n+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return solve(0,arr.length-1,arr,dp);
        
    }

    public int solve(int start,int end,int arr[],int dp[][]){
        if(start==end) return 0;
        if (dp[start][end]!=-1)
            return dp[start][end];
        int ans=Integer.MAX_VALUE;

            for(int j=start;j<end;j++){
                ans=Math.min(ans,(getmax(start,j,arr)*getmax(j+1,end,arr)+solve(start,j,arr,dp)+solve(j+1,end,arr,dp)));
            }
        return dp[start][end]=ans;

    }

    public int getmax(int start,int end,int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}


//Tabulation
//TC O(N^3)
//SC O(N^2)
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n=arr.length;
        int dp[][]=new int[n][n];
       
        for(int start=n-1;start>=0;start--){
            for(int end=start+1;end<n;end++ ){
            int ans=Integer.MAX_VALUE;

            for(int j=start;j<end;j++){
                ans=Math.min(ans,(getmax(start,j,arr)*getmax(j+1,end,arr))+dp[start][j]+dp[j+1][end]);
            }
            dp[start][end]=ans;

            }
        }
        return dp[0][n-1];
        
    }



    //Instead to looping always we can store the max of range(x,y) via using pair type in hashmap.
	//If we use hashMap then we should override the equals and hashcode methods else it will return null.
    public int getmax(int start,int end,int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
	
}

//Question Link:https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/description/
