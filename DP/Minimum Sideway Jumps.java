import java.util.Arrays;

//Recursive.
//TC  O(3^N)
//SC O(N)  obstacles length and some minimal space for over head calculation.
class Solution {
    public int minSideJumps(int[] obstacles) {
        return solve(obstacles,0,2);
    }

    public int solve(int[] obstacles,int position,int lane){
        if(position==obstacles.length-1) return 0;
        
        int res=Integer.MAX_VALUE;
        if(obstacles[position+1]!=lane){
            return solve(obstacles,position+1,lane);
        }else{
            for(int k=1;k<=3;k++){
                if(k!=lane && obstacles[position]!=k){
                res=Math.min(res,1+solve(obstacles,position,k));    
                }
            }
            return res;
        }

    }
}



//Memoization.
//TC O(4*N) ==> O(N)
//SC O(4*N) ==> O(N)
class Solution {
    public int minSideJumps(int[] obstacles) {
        int dp[][]=new int[4][obstacles.length];

        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        return solve(obstacles,0,2,dp);
    }
 
    public int solve(int[] obstacles,int position,int lane,int dp[][]){
        if(position==obstacles.length-1) return 0;

        if(dp[lane][position]!=-1) return dp[lane][position];
        
        int res=Integer.MAX_VALUE;
        if(obstacles[position+1]!=lane){
            return dp[lane][position]= solve(obstacles,position+1,lane,dp);
        }else{
            for(int k=1;k<=3;k++){
                if(k!=lane && obstacles[position]!=k){
                res=Math.min(res,1+solve(obstacles,position,k,dp));    
                }
            }
            return dp[lane][position]=res;
        }

    }

    
}


//Tabulation
//TC O(4*N) ==> O(N)
//SC O(4*N) ==> O(N)
class Solution {
    public int minSideJumps(int[] obstacles) {
        int n=obstacles.length-1;
        int dp[][]=new int[4][obstacles.length];

        dp[0][n]=0;
        dp[0][1]=0;
        dp[0][2]=0;
        dp[0][3]=0;


        for(int curpos=n-1;curpos>=0;curpos--){
            for(int curlane=1;curlane<=3;curlane++){
                
            if(obstacles[curpos+1]!=curlane){
                dp[curlane][curpos]=dp[curlane][curpos+1];
            }else{
                //Side way jump.
                int ans=Integer.MAX_VALUE;
                for(int k=1;k<=3;k++){
                    if(k!=curlane && obstacles[curpos]!=k){
                    ans=Math.min(ans,1+dp[k][curpos+1]);   
                    }
                }
                dp[curlane][curpos]=ans;
            }
            }
        }

        return Math.min(dp[2][0],Math.min(1+dp[1][0],1+dp[3][0]));

        
    }
}


//Space optimization
//TC O(4*N) ==> O(N)
//SC O(8) ====> O(1)
class Solution {
    public int minSideJumps(int[] obstacles) {
        int n=obstacles.length-1;

        int next[]={0,0,0,0};
        int curr[]={0,0,0,0};


        for(int curpos=n-1;curpos>=0;curpos--){
            for(int curlane=1;curlane<=3;curlane++){
                
            if(obstacles[curpos+1]!=curlane){
                curr[curlane]=next[curlane];
            }else{
                //Side way jump.
                int ans=Integer.MAX_VALUE;
                for(int k=1;k<=3;k++){
                    if(k!=curlane && obstacles[curpos]!=k){
                    ans=Math.min(ans,1+next[k]);   
                    }
                }
                curr[curlane]=ans;
            }
            }
            System.arraycopy(curr,0,next,0,curr.length);
        }

        return Math.min(next[2],Math.min(1+next[1],1+next[3]));
        
    }
}