//{ Driver Code Starts
//Initial Template for Java
// This sum is slight variation of maximum sub-array sum.
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int maxSubstring(String S) {
        // code here
        //Brute Force
        //TC O(n^2)
        //SC O(1)
        
        
        int res=0;
        for(int i=0;i<S.length();i++){
            int zerocount=0;
            int onecount=0;
            for(int j=i;j<S.length();j++){
                if(S.charAt(j)=='0'){
                    zerocount++;
                }else{
                    onecount++;
                }
                res=Math.max(res,zerocount-onecount);
            }
        }
        return (res<=0)?-1:res;
        
        
        //optimal 
        //TC O(N)
        //SC O(N)
        // This sum is slight variation of maximum sub-array sum.
        // The analogy is consider the 1 as -1 and 0 as +1 and perform the
        //maxmium sub array sum that will be equal to maximim difference b/w zeros and one
        // eg: given 11000010001
        //you consider its -1-11111-1111-1
        //now to get max diff b/w zero and one is same as max sub-array sum..
        
        //Learning if the question is asked in form of maximum sum/difference
        // Try to map with the maximum sub array sum ..
        
        int sum=0;
        int res=0;
        
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='0'){
                sum+=1;
            }else{
                sum-=1;
            }
            
            if(sum<0){
                sum=0;
            }
            res=Math.max(res,sum);

        }
        
        return (res<=0)?-1:res;
    }
}