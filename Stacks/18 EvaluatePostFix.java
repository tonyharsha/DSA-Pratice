class Solution
{
    //Function to evaluate a postfix expression.
	//TC O(N)
	//SC O(N).
    public static int evaluatePostFix(String S)
    {
        // Your code here
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<S.length();i++){
            char c=S.charAt(i);
            if(Character.isDigit(c)){
                st.push(c-'0');
            }else{
                int val1=st.pop();
                int val2=st.pop();
                int res=0;
                /*
                if(c=='+') res=val2+val1;
                else if(c=='*') res=val2*val1;
                else if(c=='/') res=val2/val1;
                else res=val2-val1;
                */
                switch(c) {
                  case '+': res=val2+val1; break;
                  case '-': res=val2-val1; break;
                  case '*': res=val2*val1; break;
                  default : res=val2/val1; break;
                }    
                st.push(res);
            }
        }
        
        return st.peek();
    }
}


//Evaluation of Prefix 
/* similar to Evaluation of postfix.
-> Reverse the prefix String Now it is converted into postfix String.
-> Evaluate the postfix expression.
*/