class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        //Siding Window.
        // TC O(N)
        // SC O(1)
        int sum=0;
        int result=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        result+=calc(sum,k,threshold);

        for(int i=k;i<arr.length;i++){
            sum-=arr[i-k];
            sum+=arr[i];
            result+=calc(sum,k,threshold);
        }

        return result;
    }

    public int calc(int sum,int k,int threshold){
        return (sum/k>=threshold)? 1:0;
    }
}