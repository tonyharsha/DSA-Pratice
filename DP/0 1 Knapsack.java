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
    //SC O(M+N)
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
}