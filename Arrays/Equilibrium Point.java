class Solution {
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
         //TC O(N)
		 //Sc O(1)
        // Your code here
        long leftsum=0;
        long totalsum=0;
        for(int i=0;i<n;i++){
            totalsum+=arr[i];
        }
        
        for(int i=0;i<n;i++){
            long rightsum=totalsum-arr[i];
            if(leftsum==rightsum) return i+1;
            leftsum+=arr[i];
            totalsum-=arr[i];
        }
        
        return -1;
    }
}