//Recursion 
//TC O(2^N)
//SC O(N)
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return solve(satisfaction,1,0);
        
    }

    public int solve(int [] satisfaction,int time,int index){
        if(index==satisfaction.length){
            return 0;
        }
       
        //exclude case.
        int exclude=0+solve(satisfaction,time,index+1);

        //include case.
        int include=satisfaction[index]*time + solve(satisfaction,time+1,index+1);

        return Math.max(include,exclude);

    }
}



//TC O(N^2)
//Sc O(N^2)
class Solution {
public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n=satisfaction.length;
        int dp[][]=new int[n+1][n+1];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return solve(satisfaction,1,0,dp);
        
    }

    public int solve(int [] satisfaction,int time,int index,int dp[][]){
        if(index==satisfaction.length){
            return 0;
        }

        if(dp[time][index]!=-1) return dp[time][index];
       
        //exclude case.
        int exclude=0+solve(satisfaction,time,index+1,dp);

        //include case.
        int include=satisfaction[index]*time + solve(satisfaction,time+1,index+1,dp);

        return dp[time][index]=Math.max(exclude,include);

    }
}



//Tabulation
//TC O(N^2)
//Sc O(N^2)
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n=satisfaction.length;
        int dp[][]=new int[n+1][n+1];

        // base case Last col every row. is return 0.
        Arrays.stream(dp).forEach(a->Arrays.fill(a,0));
        

        //Since it is bottom up approach.

        for(int index=n-1;index>=0;index--){
            //time can not exceed index it can only match or be lesser than index.
            for(int time=index;time>=0;time--){
                //exclude case.
                int exclude=0+ dp[time][index+1]; 

                //include case.
                //Specifically used time+1 instead of time is we need to handle time from 1--> n not 0--->n.
                int include=satisfaction[index]*(time+1) + dp[time+1][index+1];

                dp[time][index]=Math.max(include,exclude);

            }
        }

        return dp[0][0];
    }
}


//Space Optimization.
//TC O(N*2)
//SC O(N)
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n=satisfaction.length;
        int curr[]=new int[n+1];
        int next[]=new int[n+1];
        Arrays.fill(next,0);

        //Since it is bottom up approach.

        for(int index=n-1;index>=0;index--){
            //time can not exceed index it can only match or be lesser than index.
            for(int time=index;time>=0;time--){
                //exclude case.
                int exclude= 0 + next[time]; 

                //include case.
                //Specifically used time+1 instead of time is we need to handle time from 1--> n not 0--->n.
                int include=satisfaction[index]*(time+1) + next[time+1];

                curr[time]=Math.max(include,exclude);

            }
            System.arraycopy(curr,0,next,0,curr.length);
        }

        return next[0];
    }
}