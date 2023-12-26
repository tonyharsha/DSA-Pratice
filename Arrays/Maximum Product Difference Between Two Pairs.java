class Solution {
    public int maxProductDifference(int[] nums) {
        //TC O(N Log N)
        //SC O(N)
        
        Arrays.sort(nums);
        int n=nums.length-1;
        return (nums[n]*nums[n-1])-(nums[0]*nums[1]);
        


        //TC O(N)
        //SC O(1)
        int largest=Integer.MIN_VALUE;
        int secondlargest=Integer.MIN_VALUE;

        int smallest=Integer.MAX_VALUE;
        int secondsmallest=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=largest){
                secondlargest=largest;
                largest=nums[i];
            }

            if(nums[i]<largest){
                secondlargest=Math.max(secondlargest,nums[i]);
            }

            if(nums[i]<=smallest){
                secondsmallest=smallest;
                smallest=nums[i];
            }

            if(nums[i]>smallest ){
                secondsmallest=Math.min(secondsmallest,nums[i]);
            }
        }

        return (largest*secondlargest)-(smallest*secondsmallest);


    }
}