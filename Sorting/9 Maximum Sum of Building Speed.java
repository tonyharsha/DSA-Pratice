class Solution {
	public int maxSum(int[] nums) {
         //The question is simple just sort the array.
        //Now grouped into two elemnets to perform one task in order from left to right.
        //min speed can increase to maximum speed but
        //max speed can reduce to min speed.
        //so calculated the min of two speeds means one set and added to answer.

		Arrays.sort(nums);
		int res=0;
		for(int i=0;i<nums.length;i+=2){
			res+=nums[i];
		}
		return res;
	}
}