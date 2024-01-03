class Solution {
    public String removeDuplicates(String s) {
        //TC O(N)
        //SC O(N)
        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            if((!st.isEmpty()) && (st.peek()==s.charAt(i))){
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
        
    }
}