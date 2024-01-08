import java.util.* ;
import java.io.*; 
public class Solution {
    //Recursion
    //TC O(2^N)
    //SC Recursion stack.
    public static int findWays(int num[], int tar) {
        return recurv(num,tar);
    }

    public static int recurv(int num[],int target){
        if(target==0) return 1;
        if(target<0) return 0;

        int ans=0;
        for(int i=0;i<num.length;i++){
            ans+=recurv(num,target-num[i]);
        }
        return ans;
    }
    
 
 
    //Memoization
    //TC O(target*N) N=>length of num array
    //SC O(target)
    public static int findWays(int num[], int tar) {
        int dp[]=new int[tar+1];
        Arrays.fill(dp,-1);
        return Memo(num,tar,dp);
    }

    public static int Memo(int num[],int target,int dp[]){
        if(target==0) return 1;
        if(target<0) return 0;

        if(dp[target]!=-1) return dp[target];

        int ans=0;
        for(int i=0;i<num.length;i++){
            ans+=Memo(num,target-num[i],dp);
        }
        return dp[target]=ans;
    }


// Tabulation
//TC O(target*N) N=>length of num array
//SC O(target)
    public static int findWays(int num[], int tar) {
        int dp[]=new int[tar+1];
        dp[0]=1;
        
        for(int i=1;i<dp.length;i++){
            int ans=0;
            for(int j=0;j<num.length;j++){
                if(i-num[j]>=0)
                 ans+=dp[i-num[j]];
            }
            dp[i]=ans;
        }
        return dp[tar];
    }


}