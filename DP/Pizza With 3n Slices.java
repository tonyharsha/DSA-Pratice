import java.util.*;

//Recursive
//TC O(2^N)
//SC O(N)
// Here we have two cases.
//case1 consider first element so by default last one will be picked Hense solve(0,n-2) as n-1 is picked.
//case2 conside the second element so by default first will be picked Hense solve(1,n-1) as n-1 is not picked..
class Solution {
    public int maxSizeSlices(int[] slices) {
        int n=slices.length;
        int take=solve(0,n-2,slices,n/3);
        int nottake=solve(1,n-1,slices,n/3);
        return Math.max(take,nottake);
    }

    public int solve(int index,int end,int []slices,int count){
        if(count==0||index>end) return 0;
        int pick=slices[index]+solve(index+2,end,slices,count-1);
        int notpick=0+solve(index+1,end,slices,count);

        return Math.max(pick,notpick);
    }
}


//Memoization
//TC O(N^2)
//SC O(N^2)

//0->n-2 && n/3->0.
//1->n-2 && n/3->0.
class Solution {
    public int maxSizeSlices(int[] slices) {
        int n=slices.length;
        int dp1[][]=new int[n][n];
        Arrays.stream(dp1).forEach(a->Arrays.fill(a,-1));
        int take=solve(0,n-2,slices,n/3,dp1);
        int dp2[][]=new int[n][n];
        Arrays.stream(dp2).forEach(a->Arrays.fill(a,-1));
        int nottake=solve(1,n-1,slices,n/3,dp2);
        return Math.max(take,nottake);
    }

        public int solve(int index,int end,int []slices,int count,int dp[][]){
        if(count==0||index>end) return 0;

        if(dp[index][count]!=-1) return dp[index][count];
        int pick=slices[index]+solve(index+2,end,slices,count-1,dp);
        int notpick=0+solve(index+1,end,slices,count,dp);

        return dp[index][count]= Math.max(pick,notpick);
    }
}



//Tabulation
//TC O(N^2)
//SC O(N)
//n-2->0 && 0->n/3.
//n-1->1 && 0->n/3.
// added n+2 for dp array to over come array out of bound index..
class Solution {
    public int maxSizeSlices(int[] slices) {
        int n=slices.length;
        int dp1[][]=new int[n+2][n+2];

        for(int index=n-2;index>=0;index--){
            for(int count=1;count<=n/3;count++){
                int pick=slices[index]+dp1[index+2][count-1];
                int notpick=0+dp1[index+1][count];

                dp1[index][count]=Math.max(pick,notpick);
            }
        }

        int dp2[][]=new int[n+2][n+2];
        for(int index=n-1;index>0;index--){
            for(int count=1;count<=n/3;count++){
                int pick=slices[index]+dp2[index+2][count-1];
                int notpick=0+dp2[index+1][count];

                dp2[index][count]=Math.max(pick,notpick);
            }
        }

        return Math.max(dp1[0][n/3],dp2[1][n/3]);  
        
    }
}


//Space optmization
//TC O(N)
//SC O(N)
//Since dp[index][count] was dependent on dp[index+2][count-1]
//                                        dp[index+1][count]
// So considered index as prev, index+1 as curr, index+2 as next...
                                   
class Solution {
    public int maxSizeSlices(int[] slices) {
        int n=slices.length;
        
        int prev1[]=new int[n+2];
        int curr1[]=new int[n+2];
        int next1[]=new int[n+2];

        for(int index=n-2;index>=0;index--){
            for(int count=1;count<=n/3;count++){
                int pick=slices[index]+next1[count-1];
                int notpick=0+curr1[count];

                prev1[count]=Math.max(pick,notpick);
            }
            System.arraycopy(curr1,0,next1,0,curr1.length);
            System.arraycopy(prev1,0,curr1,0,prev1.length);
        }
        
        int case1=curr1[n/3];

        int prev2[]=new int[n+2];
        int curr2[]=new int[n+2];
        int next2[]=new int[n+2];
        for(int index=n-1;index>0;index--){
            for(int count=1;count<=n/3;count++){
                int pick=slices[index]+next2[count-1];
                int notpick=0+curr2[count];

                prev2[count]=Math.max(pick,notpick);
            }
            System.arraycopy(curr2,0,next2,0,curr2.length);
            System.arraycopy(prev2,0,curr2,0,prev2.length);
        }

        int case2=curr2[n/3];
        return Math.max(case1,case2);  
        
    }
}