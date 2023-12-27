class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //This is solved using Binary Search
        //Hence need to find te search space 
        // It is between the max element to total sum of array.
        // write an small function to get no of days for random nimber.
        //Then apply binary serach in that space.
        int max=0;
        int Tsum=0;
        int res=0;
        for(int i=0;i<weights.length;i++){
            Tsum+=weights[i];
            max=Math.max(max,weights[i]);
        }

        int low=max;
        int high=Tsum;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(NumOfDays(weights,mid)<=days){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return res;
    }

//function to calculate the no of days to random number.
    public int NumOfDays(int weights[],int cap){
        int totaldays=1;
        int sum=0;
        for(int i=0;i<weights.length;i++){
            if(sum+weights[i]>cap){
                totaldays++;
                sum=weights[i];
            }else{
                sum+=weights[i];
            }
        }
        return totaldays;
    }
}

