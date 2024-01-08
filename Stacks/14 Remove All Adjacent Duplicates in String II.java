//TC O(N+x) x is length of char repeated K-y times y<K.
//SC O(N) 
class Solution {
    //Created a new class which stores the char and count of char.
    class pair{
        char num;
        int count;
        public pair(char num,int count){
            this.num=num;
            this.count=count;
        }

        public int getCount(){
            return this.count;
        }

        public void setCount(int count){
            this.count=count;
        }

        public char getNum(){
            return this.num;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<pair> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!st.isEmpty() && st.peek().getNum()==c){
                st.peek().setCount(st.peek().getCount()+1);
                //if the char is repeated k times then pop it.
                if(st.peek().getCount()==k) st.pop();
            }else{
                st.push(new pair(c,1));
            }
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            int count=st.peek().getCount();
            //loop because if few char are repeated k-x times  so.
            for(int i=0;i<count;i++){
                sb.append(st.peek().getNum());
            }
            st.pop();
        }

        return sb.reverse().toString();
        
    }
}