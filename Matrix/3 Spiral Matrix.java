class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left=0;
        int top=0;
        int right=matrix[0].length-1;
        int bottom=matrix.length-1;

        ArrayList<Integer> res=new ArrayList<>();

        while(left<=right && top<=bottom){
            
            //left->right.
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
             top++;
            
            //top->bottom
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
             right--;
            
            //right->left
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                res.add(matrix[bottom][i]);
              }
             bottom--;
            }

            //bottom->top 
            if(left<=right){
            for(int i=bottom;i>=top;i--){
                res.add(matrix[i][left]);
            }
            left++;
            }
        }
        return res;
        
    }
}