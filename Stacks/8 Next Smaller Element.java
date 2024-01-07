class Solution {
	public int[] nextSmallerElement(int[] arr) {
		// TC O(N+k)
		// SC O(N).
		int n=arr.length;
		int res[]=new int[n];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                res[st.peek()]=arr[i];
                st.pop();
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            res[st.peek()]=-1;
            st.pop();
        }
		return res;
	}
}