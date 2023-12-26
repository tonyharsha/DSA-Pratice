class Solution {
    //TC O(N)
    //SC O(N)
    public int trap(int[] height) {
        int n=height.length;
        int lmax[]=new int[n];
        int rmax[]=new int[n];
        lmax[0]=height[0];
        for(int i=1;i<n;i++){
            lmax[i]=Math.max(lmax[i-1],height[i]);
        }

        rmax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rmax[i]=Math.max(rmax[i+1],height[i]);
        }

        int result=0;
        for(int i=0;i<n;i++){
            //IMP STEP.
            result+=Math.abs(height[i]-Math.min(lmax[i],rmax[i]));
        }

        return result;
        
    }
}