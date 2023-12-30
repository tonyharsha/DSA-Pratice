class Solution {
    public int deleteGreatestValue(int[][] grid) {
        //sort each row
        for(int i[]:grid){
            Arrays.sort(i);
        }
        
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            //find the max in each column.
            int max=grid[0][i];
            for(int j=1;j<m;j++){
                max=Math.max(max,grid[j][i]);
            }
            ans+=max;
        }

        return ans;
        
    }
}
}