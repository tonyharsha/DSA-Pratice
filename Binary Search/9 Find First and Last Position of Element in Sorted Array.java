class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length==0) return new int[]{-1,-1};
        int res[]=new int[2];
        res[0]=firstOccurance(nums,target);
        if(res[0]!=-1){
            res[1]=lastOccurance(nums,target);
        }else{
            res[1]=-1;
        }
        return res;

        
    }

    public int firstOccurance(int nums[],int target){
        if(nums[0]==target) return 0;

        int start=1;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target) {
                if(nums[mid]!=nums[mid-1]){
                     return mid;
                }
                else{
                    end=mid-1;
                }
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return -1;


    }


    public int lastOccurance(int nums[],int target){
        int n=nums.length-1;
        if(nums[n]==target) return n;

        int start=0;
        int end=nums.length-2;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                if(nums[mid]!=nums[mid+1])
                   return mid;
                else{
                    start=mid+1;
                }
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }

        return -1;


    }


}