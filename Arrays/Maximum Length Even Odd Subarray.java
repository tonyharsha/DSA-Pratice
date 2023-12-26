class Solution {
	//Maximum Length Even Odd Subarray.
    //TC O(N)
    //SC O(1)
    //Buy and sell Multiple times.
    public int maxlength(int[] nums) {
        int count=0;
		int result=0;
		for(int i=1;i<nums.length;i++){
		  if((nums[i]%2==0 && nums[i-1]%2!=0) || (nums[i]%2!=0 && nums[i-1]%2==0)){
			  count++;
			  result=Math.max(result,count);
		  }
		  else{
			  count=0;
		  }
		}
		return result;
    }
}