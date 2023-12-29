class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        //TC O(K*(M+N))  M=Row  N=col  K=length of indices.
        //SC O(M*N)
        
        int res[][]=new int[m][n];
        int count=0;
        for(int i=0;i<indices.length;i++){
            int row=indices[i][0];
            int column=indices[i][1];

            for(int j=0;j<n;j++){
                res[row][j]+=1;
            }

            for(int k=0;k<m;k++){
                res[k][column]+=1;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(res[i][j]%2!=0){
                    count++;
                }
            }
        }

        return count;
        

        //TC O(K+M+N) M=Row  N=col  K=length of indices
        //SC O(M+N);

        int row[]=new int[m];
        int col[]=new int[n];

        for(int i=0;i<indices.length;i++){
            row[indices[i][0]]++;
            col[indices[i][1]]++;
        }

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int num=row[i]+col[j];
                if(num%2!=0){
                    count++;
                }
            }
        }
        return count;
        
    }
}