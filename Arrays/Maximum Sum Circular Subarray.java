class Solution {
    //TC O(N)
    //SC O(1)

    //maxcircularsubarraysum= Totalsum-minsubarraysum.
    //return max(maxsubarraysum,maxcircularsubarraysum)
    public int maxSubarraySumCircular(int[] nums) {
        int maxsubarraysum=nums[0];
        int runningsum=0;

        //maxsubarraysum
        for(int i=0;i<nums.length;i++){
            runningsum+=nums[i];
            maxsubarraysum=Math.max(maxsubarraysum,runningsum);
            if(runningsum<0) runningsum=0;
        }

        int totalsum=0;
        int minsubarraysum=nums[0];
        runningsum=0;
		
		//min subarraysum.
        for(int i=0;i<nums.length;i++){
            totalsum+=nums[i];
            runningsum+=nums[i];
            minsubarraysum=Math.min(minsubarraysum,runningsum);
            if(runningsum>0) runningsum=0;
        }

        //if all the elements in nums are negative then
        if(totalsum==minsubarraysum) return maxsubarraysum;

        return Math.max(maxsubarraysum,(totalsum-minsubarraysum));
    }
}