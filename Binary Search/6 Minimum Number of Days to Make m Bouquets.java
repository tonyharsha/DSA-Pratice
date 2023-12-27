class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int n=bloomDay.length;
        //edge case.
        if(n<(long)m*k) return -1;

        //Search space is min & Max of array elements.
        int min=bloomDay[0];
        int max=bloomDay[0];
        for(int i=0;i<n;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }

        int start=min;
        int end=max;
        int res=max;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(validateDays(bloomDay,k,mid)>=m){
                res=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return res;
    }

    public int validateDays(int bloomDay[],int k,int num){
        int bouquets=0;
        int count=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=num){
                count++;
            }else{
                count=0;
            }
            if(count==k){
               bouquets++; 
               count = 0; // Reset count after forming a bouquet
            }
        }
        return bouquets;
    }
}