class Solution {
    public int search(int[] nums, int target) {

        // check if left array is sorted or not.
        // left array sorted.
        // check if target is within the range and make movement.
        // Right array sorted.
        // check if target is within the range and make movement.
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return mid;
            //check if left array is sorted.
            else if(nums[mid]>=nums[start]){
                //target in left array range
                if(nums[start]<=target && nums[mid]>=target){
                    end=mid-1;
                }else{
                    start=mid+1; //target in right array range.
                }
            }else{
                //Right array sorted
                if(nums[mid]<=target && nums[end]>=target){
                    start=mid+1; // target in right array range
                }else{
                    end=mid-1; // target in left array range.
                }
            }
        }
    return -1;
        
    }
}