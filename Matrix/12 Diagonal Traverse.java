class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        //when ever traversal is given try to find the logic via indexes i,j
        //when noticed in depth in a diagnal all the element indexes sum remains same.

        //The total number of diagonal is row+col-1
        int row=mat.length;
        int col=mat[0].length;
        int res[]=new int[row*col];
        int index=0;

        int totaldiagonal=row+col-1;
        for(int d=0;d<totaldiagonal;d++){
            //Inside each diagonal we have multiple combination.
            //such as for sum 2=> [2,0],[1,1],[0,2].....
            for(int i=0;i<=d;i++){
                int j=d-i;
            //validating the valid index and if d is odd move from down to up
                if(i<row && j<col && d%2!=0){
                    res[index++]=mat[i][j];
                }
            //validating the valid index and if d is even move from up to down
            //since i and j swaped validation condition also changed
                if(i<col && j<row && d%2==0){
                    res[index++]=mat[j][i];
                }
            }
        }

        return res;

    }
}