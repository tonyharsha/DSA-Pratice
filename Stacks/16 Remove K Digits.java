class Solution {
    //TC O(N+K)
	//SC O(N).
    public String removeKdigits(String num, int k) {
        //edge case when k==length of num.
        if(num.length()==k) return "0";
        Stack<Character> st=new Stack<>();

        //use the peek concept.
        //If the previous val is greater than current then pop() it.
        for(int i=0;i<num.length();i++){
            //int c=Integer.parseInt(String.valueOf(num.charAt(i)));
            char c=num.charAt(i);
            while(!st.isEmpty() && st.peek()>c && k>0){
                st.pop();
                k--;
            }
            if(st.isEmpty() && c=='0') continue;
            st.push(c);

        }

       // In case all the char elements are in increase order
       // We will not be able to find peek so pop() from max value.
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        
        //If sb is empty() then append 0 to cover edge case.
        if(sb.length()==0) sb.append(0);
        return sb.reverse().toString();
    }
}