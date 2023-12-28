class Solution {
	public int samHeight(int[] nums, int S) {
        //This is very simple given n heights.
        //now crate new array with n+1 heights and sort them.

        //Now find the position of S 
        // To make it to be middle we should either add in left or delete in right.
        //Since adding and deleting costs same we are taking abs. of left side and right side.
	
        int n=nums.length;
		int res[]=new int[n+1];
		for(int i=0;i<n;i++){
			res[i]=nums[i];
		}
		res[n]=S;
		Arrays.sort(res);

		int index=Search(res,0,n,S);
        
		int leftside=index-0;
		int rightside=res.length-index-1;
		return Math.abs(leftside-rightside);
	}

	public int Search(int []nums,int start,int end,int S){
		while(start<=end){
			int mid=start+(end-start)/2;
			if(nums[mid]==S) return mid;
			else if(nums[mid]>S){
				end=mid-1;
			}else{
				start=mid+1;
			}
		}
		return -1;
	}
}