class Solution {
    //TC O(N)
    //SC O(1)
    //Main logic using prefix and suffix sum 
    //Here Totalsum-nums[i] ==> suffix sum.
    public int pivotIndex(int[] nums) {
        int totalsum=0;
        for(int i=0;i<nums.length;i++){
            totalsum+=nums[i];
        }

        int leftsum=0;
        for(int i=0;i<nums.length;i++){
            int rightsum=totalsum-nums[i];
            if(leftsum==rightsum) return i;
            leftsum+=nums[i];
            totalsum-=nums[i];
        }

        return -1;

        
    }
}