//TC O(N^2)
//SC O(N)
class Solution {
    public int maxHeight(int[][] cuboids) {
          // Sorting all Dimensions
        for(int []arr:cuboids){
            Arrays.sort(arr);
        }

       // sort all cuboids on basis of length, if same then breadth,
        // if same then height
        Arrays.sort(cuboids,(a,b)->{
            if(a[0]==b[0]){
                if(a[1]==b[1]){
                    return a[2]-b[2];
                }
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

       /*
        Arrays.sort(cuboids,(a,b)->
        (a[0]==b[0])?((a[1]==b[1])?a[2]-b[2]:a[1]-b[1]):a[0]-b[0]);
       */

        // use logic of LIS(Longest Increasing Subsequence)
		//Here we have used Space optimized method not the Binary Serach method Because 
		//Here we need to give sum of heights not length of Incresing Sequence
        int n=cuboids.length;
        int curr[]=new int[n+1];
        int next[]=new int[n+1];

       
        for(int index=n-1;index>=0;index--){
            for(int prev=index-1;prev>=-1;prev--){
                    int inc=0;
                    if(prev==-1 || cuboids[index][0]>=cuboids[prev][0] && 
                                   cuboids[index][1]>=cuboids[prev][1] &&
                                   cuboids[index][2]>=cuboids[prev][2]){
                     //The second parameter goes with +1.
                     inc= cuboids[index][2]+ next[index+1];
                     }
                    //The second parameter goes with +1.
                    int exc= 0+ next[prev+1];
            

                curr[prev+1]=Math.max(inc,exc);

            }
            System.arraycopy(curr,0,next,0,curr.length);
        }
        return next[0];


        
    }
}