class Solution {
    //TC O(N+k)
	//SC O(N).
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		
		//Method 1 perefer this one only.
		HashMap<Integer,Integer> hm=new HashMap<>();
        Stack<Integer> st=new Stack<>();

        int res2[]=new int[nums2.length];
        //The Main logic is 
        //If elements are smaller then keep on adding their indices.
        //Once you find the greater element 
        //Traverse to all the indices via stack and update their next greater value.
        for(int i=0;i<nums2.length;i++){
            while(!st.isEmpty() && nums2[st.peek()]<nums2[i]){
                res2[st.peek()]=nums2[i];
                hm.put(nums2[st.peek()],res2[st.peek()]);
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            res2[st.peek()]=-1;
            hm.put(nums2[st.peek()],-1);
            st.pop();
        }

        int res1[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            res1[i]=hm.get(nums1[i]);
        }

        return res1;
		
		
		
		//Method 2.
        HashMap<Integer,Integer> hm=new HashMap<>();
        Stack<Integer> st=new Stack<>();

        int n=nums2.length;
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                hm.put(nums2[i],-1);
                st.push(nums2[i]);
            }else{
			    //Main logic is here Remove the elements in the stack which are lesser than the current element with index i in nums2.
                while(!st.isEmpty() && nums2[i]>st.peek()){
                    st.pop();
                }
                if(st.isEmpty()){
                    hm.put(nums2[i],-1);
                }else{
                    hm.put(nums2[i],st.peek());
                }
                st.push(nums2[i]);
            }
        }

        int ans[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=hm.get(nums1[i]);
        }

        return ans;
        
    }
}