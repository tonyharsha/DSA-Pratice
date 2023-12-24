class Solution {
    public void moveZeroes(int[] nums) {
        //Brute Force
        //TC O(N^2)
        //SC O(1).
        /*
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j]!=0){
                        int temp=nums[i];
                        nums[i]=nums[j];
                        nums[j]=temp;
                        break;
                    }
                }
            }
        }
        */

        //Optimal
        //TC O(N)
        //SC O(1).
        int nonZeroIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[nonZeroIndex++]=nums[i];
            }
        }

        for(int i=nonZeroIndex;i<nums.length;i++){
            nums[i]=0;
        }



        
    }
}