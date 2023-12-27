class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //Using Binary search approach
        //Find the search space that is 1 to max of array.
        int max=piles[0];
        for(int i=0;i<piles.length;i++){
            max=Math.max(max,piles[i]);
        }

        int start=1;
        int end=max;
        int res=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(validateHours(piles,mid)<=h){
                res=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return res;
        
    }

    public int validateHours(int []piles,int num){
        int hours=0;
        for(int i=0;i<piles.length;i++){
            //if we dont use double then division will return integer rounded value
            //ceil on rounded value will give the same value. 
            hours+=Math.ceil((double)piles[i]/num);
        }
        return hours;
    }
}