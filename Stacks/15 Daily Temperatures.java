class Solution {
    //Same logic used to Next greater element with little modification.
    //TC O(N)
    //Sc O(N)
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st=new Stack<>();
        int res[]=new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                res[st.peek()]=i-st.peek();
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            res[st.peek()]=0;
            st.pop();
        }

        return res;
        
    }
}