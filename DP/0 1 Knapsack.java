import java.util.* ;
import java.io.*; 

public class Solution{
    //Recursion
    //TC Exponential
    //SC Recursion stack.
    
    static int Recurv(int[] weight, int[] value, int n, int capacity){
        if(n==0){
            if(weight[n]<=capacity){
                return value[n];
            }else{
                return 0;
            }
        }

        int include=0;
        if(weight[n]<=capacity){
            include=value[n]+Recurv(weight,value,n-1,capacity-weight[n]);
        }

        int exclude=0+Recurv(weight,value,n-1,capacity);

        return Math.max(include,exclude);
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return Recurv(weight,value,n-1,maxWeight);

    }
    

    //Memoizaton
    //TC O(M+N)
    //SC O(M*N)
    
    static int Recurv(int[] weight, int[] value, int n, int capacity,int dp[][]){
        if(n==0){
            if(weight[n]<=capacity){
                return value[n];
            }else{
                return 0;
            }
        }

        if(dp[n][capacity]!=-1) return dp[n][capacity];

        int include=0;
        if(weight[n]<=capacity){
            include=value[n]+Recurv(weight,value,n-1,capacity-weight[n],dp);
        }

        int exclude=0+Recurv(weight,value,n-1,capacity,dp);

        return dp[n][capacity]= Math.max(include,exclude);
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][]=new int[n][maxWeight+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return Recurv(weight,value,n-1,maxWeight,dp);

    }
    
    // Tabulation
    // TC O(M+N)
    // SC O(M*N)
    
    static int Tabulation(int[] weight, int[] value, int n, int capacity){
        int dp[][]=new int[n][capacity+1];
        
        Arrays.stream(dp).forEach(a->Arrays.fill(a,0));
        for(int w=weight[0];w<=capacity;w++){
            if(weight[0]<=capacity){
                dp[0][w]=value[0];
            }else{
                dp[0][w]=0;
            }
        }


        for(int index=1;index<n;index++){
            for(int w=0;w<=capacity;w++){

                int include=0;
                if(weight[index]<=w){
                    include=value[index]+dp[index-1][w-weight[index]];
                }
                int exclude=0+dp[index-1][w];
                dp[index][w]=Math.max(include,exclude);
            }
        }
        return dp[n-1][capacity];
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return Tabulation(weight,value,n,maxWeight);

    }
    
    // Space optimization
    // TC O(M+N)
    // SC O(2M)=> O(M)  M= weights N=n.
    static int SpaceOptimization(int[] weight, int[] value, int n, int capacity){
        int prev[]=new int[capacity+1];
        int curr[]=new int[capacity+1];

        Arrays.fill(prev,0);
        Arrays.fill(curr,0);
        
        for(int w=weight[0];w<=capacity;w++){
            if(weight[0]<=capacity){
                prev[w]=value[0];
            }else{
                prev[w]=0;
            }
        }


        for(int index=1;index<n;index++){
            for(int w=0;w<=capacity;w++){

                int include=0;
                if(weight[index]<=w){
                    include=value[index]+prev[w-weight[index]];
                }
                int exclude=0+prev[w];
                curr[w]=Math.max(include,exclude);
            }
            prev=Arrays.copyOf(curr,curr.length);
        }
        return prev[capacity];
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return SpaceOptimization(weight,value,n,maxWeight);

    }



}