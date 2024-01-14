class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
        //Infix to postFix just follow the rules.
        //If letter or digit add to res.
        //If ( then add to stack.
        //If ) then pop the stack till you find ) and add those poped values to res.
        //If it is operators then use precedence like if operator precedence is greater than peek then add
        // or pop till the operator precendence is less than or equal to peek of stack.\
        //TC O(N)
        //Sc O(N)
        StringBuilder sb=new StringBuilder();
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                sb.append(c);
            }
            else if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && getPrecdence(c)<=getPrecdence(st.peek()) ){
                    sb.append(st.pop());
                }
                st.push(c);
            }
       }
       
       while(!st.isEmpty()){
           sb.append(st.pop());
       }
       
       return sb.toString();
    }
    
    public static int getPrecdence(char ch){
        if(ch=='^') return 2;
        if(ch=='*'|| ch=='/') return 1;
        if(ch=='+'|| ch=='-') return 0;
        return -1;
    }
}