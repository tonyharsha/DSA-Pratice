class Solution {
    //TC O(N)
    //SC O(1)
    public int maximumDifference(int[] nums) {
        int min=nums[0];
        int res=0;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            res=Math.max(res,nums[i]-min);
        }
        return (res==0)?-1:res;
    }
}