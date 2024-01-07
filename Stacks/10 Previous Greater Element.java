class Solution {
	public int[] previousGreaterElement(int[] arr) {
		 //TC O(N+K)
		//SC O(N)
		// same laogic used for next greater element only change is traverse from last to first.
		int n=arr.length;
		int res[]=new int[n];
		Stack<Integer> st=new Stack<>();
		for(int i=n-1;i>=0;i--){
			while(!st.isEmpty() && arr[st.peek()]<arr[i]){
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