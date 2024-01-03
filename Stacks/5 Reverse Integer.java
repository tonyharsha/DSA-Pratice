class Solution {
    public int reverse(int x) {
        //TC O(N)
        //SC O(1)
        long FinalNumber=0;
        int num=x;
        while(num!=0){
            int lastDigit=num%10;
            FinalNumber*=10;
            FinalNumber+=lastDigit;
            num=num/10;
        }


        // check if it is in Integer range.
        if(FinalNumber<Integer.MIN_VALUE || FinalNumber>Integer.MAX_VALUE) return 0;


        return (int)FinalNumber;
        

        //Using Stack.
        //TC O(N) 
        //SC O(N) 
        String s=String.valueOf(x);
        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='-'){
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        int ans=0;
        try{
            //Using try block because if value is greater than int value then we cant do
            //Integer.parse which will lead to Exception.
            ans=Integer.parseInt(sb.toString());
        }catch(NumberFormatException e){
            return ans;
        }

        return (x<0)?-1*ans:ans;
    }
}