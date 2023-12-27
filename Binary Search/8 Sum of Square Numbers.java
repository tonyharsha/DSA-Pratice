class Solution {
    public boolean judgeSquareSum(int c) {
        //Two pointer approach
        // Efficient.
        //TC O(sqrt(C))
        //SC O(1).
        
        long start=0;
        long end=(long)Math.sqrt(c);
        while(start<=end){
            long res=(start*start)+(end*end);
            if(res==c) return true;
            else if(res>c) end--;
            else start++;
        }

        return false;
        

        //This can be solved by Binary Search also.
        
        // TC O(C) +O(log C)
		// Sc O(1)
        int perfectsquare=(int)Math.sqrt(c);
        
        //edge case eg 0*0+2*2 =>4. 
        if(perfectsquare*perfectsquare ==c) return true;

        for(int i=1;i<=perfectsquare;i++){
            int k=(c-(i*i));
            //if(checkperfectsquare(k)) return true;
            if(calculate(perfectsquare,i,k)) return true;
        }
        return false;

        
    }

    public boolean checkperfectsquare(int num){
        int check=(int)Math.sqrt(num);
        if((check*check)==num) return true;
        return false; 
    }

    public boolean calculate(int max,int i,int target){
        int low=i;
        int high=max;
        while(low<=high){
            int mid=low+(high-low)/2;
            if((mid*mid)==target){
                return true;
            }else if((mid*mid)>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return false;

    }
}