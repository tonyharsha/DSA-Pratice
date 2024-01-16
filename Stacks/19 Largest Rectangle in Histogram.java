//TC O(N^2)
//SC O(1)
/*
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res=0;
        for(int i=0;i<heights.length;i++){
            int currsum=heights[i];
            for(int j=i-1;j>=0;j--){
                if(heights[j]>=heights[i]){
                    currsum+=heights[i];
                }else{
                    break;
                }
            }

            for(int j=i+1;j<heights.length;j++){
                if(heights[j]>=heights[i]){
                    currsum+=heights[i];
                }else{
                    break;
                }
            }
            res=Math.max(res,currsum);
        }
        
        return res;
    }
}
*/ 

TC O(N)
SC O(N).

class Solution {
    public int largestRectangleArea(int[] heights) {
        int Ps[]=new int[heights.length];
        int Ns[]=new int[heights.length];

        Stack<Integer> st=new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                Ps[st.peek()]=i;
                st.pop();
            }
            st.push(i);
        }

        // If we are not able to find the previous smaller element then consider the start of array - 1 that is -1..
        while(!st.isEmpty()){
            Ps[st.peek()]=-1;
            st.pop();
        }

        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                Ns[st.peek()]=i;
                st.pop();
            }
            st.push(i);
        }

        // If we are not able to find the next smaller element then consider end of the array+1 that is length of array.
        while(!st.isEmpty()){
            Ns[st.peek()]=heights.length;
            st.pop();
        }

        int res=0;
        for(int i=0;i<heights.length;i++){
            /*
            int currSum=heights[i];
            currSum+=(i-Ps[i]-1)*heights[i];
            currSum+=(Ns[i]-i-1)*heights[i];
            */
            int currSum=(Ns[i]-Ps[i]-1)*heights[i];
            res=Math.max(res,currSum);
        }

        return res;
        
    }
}