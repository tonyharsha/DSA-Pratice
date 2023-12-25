//Brute Force

//TC O(n^2)
//SC O(1).

class Solution {
    public int maxSubArray(int[] nums) {
 
        int res=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                res=Math.max(res,sum);
            }
           
        }
        return res;
        
    }
}


//Optimal 
//TC O(N)
//SC O(1)


//Kandane's Algo
//Three Steps
//Always res=first elemnt of array.
//Sum==> sum+=arr[i] current sum and get the max sum into res.
//if(sum<0) set sum=0.
class Solution {
    public int maxSubArray(int[] nums) {
 
       int res=nums[0];
       int sum=0;
       for(int i=0;i<nums.length;i++){
           sum+=nums[i];
           res=Math.max(res,sum);
           if(sum<0) sum=0;
       }

       return res;
        
    }
}