//MAX IN Array
//TC O(n)
//SC O(1).
class Solution {
    public int findLargestElement(int []nums) {
        // Your code goes here
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
        }
        return max;
    }
}

//MIN IN Array
//TC O(n)
//SC O(1)
class Solution {
	public int findSmallest(int[] nums) {
		// Your code goes here
		int res=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++) {
			res=Math.min(res,nums[i]);
		}
		return res;
	}
}

//Second Smallest Element In Array
//TC O(n)
//SC O(1)

class Solution {
	public int secondSmallest(int[] nums) {
		// Your code goes here
		int smallest=Integer.MAX_VALUE;
		int secondSmallest=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++){
			if(nums[i]<smallest){
				secondSmallest=smallest;
				smallest=nums[i];
			}
			if(nums[i]>smallest){
				secondSmallest=Math.min(secondSmallest,nums[i]);
			}
		}
		return secondSmallest;
	}
}

//Second Largest Element
//TC O(n)
//SC O(1)
class Solution {
	public int secondLargest(int[] nums) {
		// Your code goes here
		int largest=Integer.MIN_VALUE;
		int secondLargest=Integer.MAX_VALUE;

		for(int i=0;i<nums.length;i++){
			if(nums[i]>largest){
				secondLargest=largest;
				largest=nums[i];
			}

			if(nums[i]<largest){
				secondLargest=Math.max(secondLargest,nums[i]);
			}
		}
		return secondLargest;
	}
}

//Reverse An Array
//TC O(N/2)~O(N).
//Sc O(1)
class Solution {
    public int[] reverseArray(int[] nums) {
        // Your code goes here
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        return nums;
    }
}