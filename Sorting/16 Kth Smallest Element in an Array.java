class Solution {
    // This can be solved via Arrays.sort.
	// Here used Quick sort partation technique.
    public int findKthSmallest(int[] nums, int k) {
        int end=nums.length-1;
        int start=0;
        while(start<=end){
            int index=partation(nums,start,end);
            if(index==k-1) return nums[index];
            else if(index>k-1){
                end=index-1;
            }else{
                start=index+1;
            }
        }
        return -1;        
    }

    public int partation(int nums[],int left,int right){
        int i=left-1;
        int povit=right;
        for(int j=left;j<right;j++){
            if(nums[j]<nums[povit]){
                i++;
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }
        }
        i++;
        int temp=nums[povit];
        nums[povit]=nums[i];
        nums[i]=temp;
        return i;
    }
}