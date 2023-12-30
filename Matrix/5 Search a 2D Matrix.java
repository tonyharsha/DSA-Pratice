class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Two pointer
        
        int left=0;
        int right=matrix[0].length-1;
        
        while(left<=matrix.length-1 && right>=0){
            if(matrix[left][right]==target) return true;
            else if(matrix[left][right]>target){
                right--;
            }else{
                left++;
            }
        }
        return false;
        


        //Binary Search
        int low=0;
        int m=matrix.length;
        int n=matrix[0].length;
        int high=m*n-1;
        while(low<=high){
            int mid=(low+(high-low)/2);
            if(matrix[mid/n][mid%n]==target){
                return true;
            }
            else if(matrix[mid/n][mid%n]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;  
        
    }
}

