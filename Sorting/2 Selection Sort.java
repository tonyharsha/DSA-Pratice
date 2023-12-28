//iterative
//Find the shortest element and move it to the begning.
//TC O(N^2)
//Sc O(1)
class Solution {
    public int[] selectionSort(int[] nums) {
         for(int i=0;i<nums.length-1;i++){
            int mini=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[mini]){
                    mini=j;
                }
            }
            int temp=nums[i];
            nums[i]=nums[mini];
            nums[mini]=temp;
        }
        return nums;
    }
}

//Recursive.
class Solution {
    public int[] sortArray(int[] nums) {
        selectionSort(nums,nums.length,0);
        return nums;
    }

    public void selectionSort(int nums[],int n,int index){
        if(index>=n) return;
        int mini=index;
        for(int i=index+1;i<n;i++){
            if(nums[i]<nums[mini]){
                mini=i;
            }
        }
        int temp=nums[index];
        nums[index]=nums[mini];
        nums[mini]=temp;

        selectionSort(nums,n,index+1);
    }
}