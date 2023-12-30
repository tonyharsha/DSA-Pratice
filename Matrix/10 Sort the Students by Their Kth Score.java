class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {


        
        //Simple we cause comparater and solve in one line
        Arrays.sort(score,(a,b)->b[k]-a[k]);
        return score;
		
		
        //Way Two Find the row which has max value at k column and swap with first row, repeat the process
        for(int i=0;i<score.length;i++){
            int maxindex=i;
            for(int j=i+1;j<score.length;j++){
                if(score[j][k]>=score[maxindex][k]){
                    maxindex=j;
                }
            }
            swap(score,i,maxindex);
        }
        return score;
        
    }

    public void swap(int [][]score ,int i,int j){
             int[] temp = score[i];
             score[i] = score[j];
             score[j] = temp;
    }
}