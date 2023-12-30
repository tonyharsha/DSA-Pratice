class Solution {
    public int[][] generateMatrix(int n) {
        int res[][]=new int[n][n];
        int left=0;
        int top=0;
        int right=res[0].length-1;
        int bottom=res.length-1;

        int val=1;
        while(left<=right && top<=bottom){
            
            //left->right.
            for(int i=left;i<=right;i++){
                res[top][i]=val++;
            }
             top++;
            
            //top->bottom
            for(int i=top;i<=bottom;i++){
                res[i][right]=val++;
            }
             right--;
            
            //right->left
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                res[bottom][i]=val++;
              }
             bottom--;
            }

            //bottom->top 
            if(left<=right){
            for(int i=bottom;i>=top;i--){
                res[i][left]=val++;
            }
            left++;
            }
        }
        return res;
        
    }
}