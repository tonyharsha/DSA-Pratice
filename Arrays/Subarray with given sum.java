//TC ~O(N)
//SC O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int runningsum=0;

        int j=0;
        for(int i=0;i<nums.length;i++){
            runningsum+=nums[i];
            if(runningsum>=k){
                while(runningsum>k && j<i){
                    runningsum-=nums[j];
                    j++;
                }
                if(runningsum==k){
                    count++;
                }
            }

            
        }

        return count;
        
    }
}