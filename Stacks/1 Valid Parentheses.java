class Solution {
    public boolean isValid(String s) {
        //TC O(N)
        //SC O(N)
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(st.isEmpty() && (c==']' ||c=='}' ||c==')') ){
                return false;
            }
            else if(c=='('||c=='{'||c=='['){
                st.push(c);
            }else{
                if(
                    (c==')' && st.peek()=='(') || 
                    (c=='}' && st.peek()=='{') || 
                    (c==']' && st.peek()=='['))
                    {
                        st.pop();
                    }
                else{
                    return false;
                }
            }
        }
        //impt to cover edge cases like "[","((["
        return st.isEmpty();
        
    }
}