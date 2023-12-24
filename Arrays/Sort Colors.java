class Solution {
    public void sortColors(int[] nums) {
        //Brute Force Any Sorting Algo I used Selection Sort.
        //TC O(N^2)
        //SC O(1).
        /*
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }
            }
        }*/

        //optimal Solution
        //TC O(N)+O(K) <Swapping operations>
        //SC O(1)
        int low=0;
        int mid=0;// This is like i looping variable.
        int high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                int temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            }else if(nums[mid]==1) {
                mid++;
            }
            else{
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }
}