import java.util.*;
public class Solution {
    //Recursion.
    //TC O(3^N)
    //SC Recursion stcak
    
    public static int cutSegments(int n, int x, int y, int z) {
        // Write your code here.
        int result=recu(n,x,y,z);
        return (result<0)?0:result;

    }

    public static int recu(int n,int x,int y,int z){
        if(n==0) return 0;
        if(n<0) return Integer.MIN_VALUE;
        
        int a=1+recu(n-x,x,y,z);
        int b=1+recu(n-y,x,y,z);
        int c=1+recu(n-z,x,y,z);

        return Math.max(a,Math.max(b,c));
    }
    

    //Memoization
    //TC O(N)
    //SC Recursion stack
    
     public static int cutSegments(int n, int x, int y, int z) {
        // Write your code here.
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        int result=recu(n,x,y,z,dp);
        return (result<0)?0:result;

    }

    public static int recu(int n,int x,int y,int z,int dp[]){
        if(n==0) return 0;
        if(n<0) return Integer.MIN_VALUE;
        
        if (dp[n]!=-1) return dp[n];
        int a=1+recu(n-x,x,y,z,dp);
        int b=1+recu(n-y,x,y,z,dp);
        int c=1+recu(n-z,x,y,z,dp);

        return dp[n]= Math.max(a,Math.max(b,c));
    }
    

    //Tabulation
    //TC O(N)
    //SC Recursio stack.
    //space optimization cant be achieved because x,y,z are dynamic in nature.
     public static int cutSegments(int n, int x, int y, int z) {
        // Write your code here.
        int dp[]=new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            if((i-x)>=0)
            dp[i]=Math.max(dp[i],dp[i-x]+1);
            if((i-y)>=0)
            dp[i]=Math.max(dp[i],dp[i-y]+1);
            if((i-z)>=0)
            dp[i]=Math.max(dp[i],dp[i-z]+1);
        }

        return (dp[n]<0)?0:dp[n];

    }

    
}