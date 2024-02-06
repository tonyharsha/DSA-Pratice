
//Recursive
//TC Exponential
//SC Recursion stack.
class Solution {
    int res=0;
    public int maximalSquare(char[][] matrix) {
        solve(matrix,0,0);
        return res*res;
    }
    public int solve(char[][] matrix,int row,int col){
        if(row>=matrix.length || col>=matrix[0].length) return 0;

        int ans=0;
        int right=solve(matrix,row,col+1);
        int diagonal=solve(matrix,row+1,col+1);
        int down=solve(matrix,row+1,col);

        if(matrix[row][col]=='1'){
            ans=1+Math.min(right,Math.min(diagonal,down));
            res=Math.max(res,ans);
        }

        return ans;
    }
}

//Memoization.
//TC O(N*M)
//SC O(N*M)
class Solution {
    int res=0;
    public int maximalSquare(char[][] matrix) {
        int dp[][]=new int[matrix.length][matrix[0].length];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,-1));
        solve(matrix,0,0,dp);
        return res*res;
    }

    public int solve(char[][]matrix, int row, int col,int dp[][]){
        if(row>=matrix.length || col>=matrix[0].length) return 0;

        if(dp[row][col]!=-1) return dp[row][col];
        int ans=0;
        int right=solve(matrix,row,col+1,dp);
        int diagonal=solve(matrix,row+1,col+1,dp);
        int down=solve(matrix,row+1,col,dp);

        if(matrix[row][col]=='1'){
            ans=1+Math.min(right,Math.min(diagonal,down));
            res=Math.max(res,ans);
        }

        return dp[row][col]=ans;

    }
}
*/
//Tabulation
//TC O(N*M)
//SC O(N*M)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int dp[][]=new int[matrix.length][matrix[0].length];
        Arrays.stream(dp).forEach(a->Arrays.fill(a,0));
        int res=0;
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=matrix[0].length-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    int right=(j+1<matrix[0].length)?dp[i][j+1]:0;
                    int diagonal=(j+1 <matrix[0].length && i+1<matrix.length)?dp[i+1][j+1]:0;
                    int down=(i+1<matrix.length)?dp[i+1][j]:0;

                    dp[i][j]=1+Math.min(right,Math.min(diagonal,down));
                    res=Math.max(res,dp[i][j]);
                }
            }
        }
        return res*res;
    }
}

//Space optimization
//TC O(N*M)
//SC O(M)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int curr[]=new int[matrix[0].length];
        int next[]=new int[matrix[0].length];
        int res=0;
        for(int i=matrix.length-1;i>=0;i--){
            for(int j=matrix[0].length-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    int right=(j+1<matrix[0].length)?curr[j+1]:0;
                    int diagonal=(j+1 <matrix[0].length && i+1<matrix.length)?next[j+1]:0;
                    int down=(i+1<matrix.length)?next[j]:0;

                    curr[j]=1+Math.min(right,Math.min(diagonal,down));
                    res=Math.max(res,curr[j]);
                }else {
					//imp.
                    curr[j] = 0; // Reset to 0 if current cell is '0'
                }
            }
            System.arraycopy(curr, 0, next, 0, curr.length);
        }
        return res*res;
    }
}
