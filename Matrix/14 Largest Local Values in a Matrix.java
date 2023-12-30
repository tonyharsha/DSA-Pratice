class Solution {
    public int[][] largestLocal(int[][] grid) {
        int result[][]=new int[grid.length-2][grid[0].length-2];

        for(int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                result[i][j]=largestLocal(grid, i,j);
            }
        }
        return result;
        
    }

    public int largestLocal(int grid[][],int i,int j){
        //Since in question given has 3*3 contiguous element we are doing +2.
        int row=i+2;
        int col=j+2;
        int max=grid[i][j];
        for(int k=i;k<=row;k++){
            for(int l=j;l<=col;l++){
                max=Math.max(max,grid[k][l]);
            }
        }
        return max;
    }
}