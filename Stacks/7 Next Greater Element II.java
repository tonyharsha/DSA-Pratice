class Solution {
    public int[] nextGreaterElements(int[] nums) {
	    // TC O(N+k)
		// SC O(N)
        //This approach is similar to Next greater element.
        //Perform same as next greater element .
        //Now all the indices in stack are the smaller elements only.
        //Since it is circular array traverse from first and use same logic when you find greader elemnent.
        //Then finally make greatest element element has -1; via traversal of stack.
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int res[]=new int[n];

        for(int i=0;i<n;i++){
            //IMP.
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                res[st.peek()]=nums[i];
                st.pop();
            }
            st.push(i);
        }

       
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                res[st.peek()]=nums[i];
                st.pop();
            }
        }
        
        while(!st.isEmpty()){
            res[st.peek()]=-1;
            st.pop();
        }

        return res;
    }
}