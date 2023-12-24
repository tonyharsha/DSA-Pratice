class Solution {
    public int removeDuplicates(int[] nums) {

        //Brute Force Via using Linked HashSet
        //TC O(N log N)
        //SC O(N)

        //Optimal Via Two pointer
        //TC O(N)
        //SC O(1)

        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]==nums[j]) continue;
            else{
                i++;
                nums[i]=nums[j];
            }
        }

        return i+1;// i+1 beacuse they asked size of array not position of last element
        
    }
}