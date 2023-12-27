class Solution {
    public int findPeakElement(int[] nums) {
  
        //edge cases.
        if(nums.length==1) return 0;
        if(nums[1]<nums[0]) return 0;
        if(nums[nums.length-2]<nums[nums.length-1]) return nums.length-1;
        //TC O(N)
        //SC O(1).
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1]&& nums[i]>nums[i+1]) return i;
        }
        return -1;
        

        //TC O(logN)
		//SC O(1)
        int start=1;
        int end=nums.length-2;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid-1]<nums[mid]&& nums[mid+1]<nums[mid]) return mid;
            else if(nums[mid]<nums[mid+1]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;


    }
}