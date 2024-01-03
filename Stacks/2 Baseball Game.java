class Solution {
    //TC O(N+K) N=string.length() K is for stack traversal.
	//Sc O(K)
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("C")){
                st.pop();
            }else if(operations[i].equals("D")){
                int prev=st.pop();
                int doubl=prev*2;
                st.push(prev);
                st.push(doubl);
            }else if(operations[i].equals("+")){
                int prev1=st.pop();
                int prev2=st.pop();
                int sum=prev1+prev2;
                //Imp first prev2 must be inserted.
                st.push(prev2);
                st.push(prev1);
                st.push(sum);
            }else{
                //converting String to Int.
                st.push(Integer.parseInt(operations[i]));
            }
        }

        int sum=0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
        
    }
}