class Solution {
    public int[] sortedSquares(int[] nums) {
        int res[]=new int[nums.length];
        int i=0;
        int j=nums.length-1;
        int index=nums.length-1;

        //Simple solution is we can use Arrays.sort function
        //But given we should slove the question O(n)


        // The main point crack this approach is given array contains negative elemnts but its sorted.
        //We should make use of this via two pointer approach.
        //start filling element from last position of array.
        //two pointers start and last.
        //compare which is greter via Math.abs then place in the required position..
        while(i<=j){
            if(Math.abs(nums[i])>nums[j]){
                res[index]=nums[i]*nums[i];
                i++;
            }else{
                res[index]=nums[j]*nums[j];
                j--;
            }
            index--;
        }
        return res;
    }
}