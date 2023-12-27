class Solution {
    public int mySqrt(int x) {
        //TC O(N)
        //SC O(1)
        
        if(x==0||x==1) return x;
        int res=0;
        for(long i=1;i<x;i++){
            if(i*i>x){
                break;
            }
            res=(int)i;
        }
        return res;
        
		
        //TC O(logN)
        //SC O(1)
        long res=0;
        if(x==0||x==1) return x;
        long start=0;
        long end=x;
        while(start<=end){
            long mid= start+(end-start)/2;
            if(mid*mid<=x){
                res=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return (int)res;
    }
}