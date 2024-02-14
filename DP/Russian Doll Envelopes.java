//TC O(NlogN)
//SC O(N)
class Solution {
    //This can be solved via finding Longest Increasing Subsequence.
    public int maxEnvelopes(int[][] envelopes) {
        //Sort the arr acending order of width if width are same then sort on height in descending.
        //Preparing the data for finding LIS.
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        
        //Now just find the LIS of 1th index element of each row.
        ArrayList<Integer> res=new ArrayList<>();
        res.add(envelopes[0][1]);
        for(int i=1;i<envelopes.length;i++){
            if(envelopes[i][1]>res.get(res.size()-1)){
                res.add(envelopes[i][1]);
            }
            else{
                int index=getIndex(res,envelopes[i][1]);
                res.set(index,envelopes[i][1]);
            }
        }

        return res.size();

        
    }

    public int getIndex(ArrayList<Integer> res,int num){
        int start=0;
        int end=res.size()-1;
        int index=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(res.get(mid)>=num){
                index=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return index;
    }
}