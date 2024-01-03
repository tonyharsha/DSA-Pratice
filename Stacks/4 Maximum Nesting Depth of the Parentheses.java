class Solution {
    public int maxDepth(String s) {
        
        //TC O(N)
        //SC O(1)
        int result=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }
            if(s.charAt(i)==')'){
                count--;
            }

            result=Math.max(result,count);
        }

        return result;
        

        //TC O(N)
        //SC O(N)
        //This is similar pattern of Valid parenthsis 
        //Check for validation and at the same time caculate the maximum depth for valid parenthsis string.
        //When u find ( increase and when you find ) decrease 
        // store the max depth and return it if given string is valid else return 0.
        Stack<Character> st=new Stack<>();
        int count=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            if(st.isEmpty() && s.charAt(i)==')'){
                return 0;
            }
            else if(s.charAt(i)=='('){
                st.push(s.charAt(i));
                count++;
                res=Math.max(res,count);
            }
            else if(!st.isEmpty() &&  s.charAt(i)==')' && st.peek()=='('){
                st.pop();
                count--;
            }
            
        }
        if(st.isEmpty()){
            return res;
        }else{
            return 0;
        }
    }
}