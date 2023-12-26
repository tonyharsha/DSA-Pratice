class Solution{
    //Function to find the maximum occurred integer in all ranges.
    //TC O(maxx)
    //SC O(maxx)
    
    public static int maxOccured(int L[], int R[], int n, int maxx){
        int arr[]=new int[maxx+10];
        
        //Increase the L indices by 1.
        for(int i=0;i<L.length;i++){
            arr[L[i]]+=1;
        }
        
        
        //Decrease the R indices+1 by 1.
        for(int i=0;i<R.length;i++){
            arr[R[i]+1]-=1;
        }
        
        int max=arr[0];
        int maxoccuring=0;
        
        //Tracking the max occuring index.
        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i]+arr[i-1];
            if(arr[i]>max){
                max=arr[i];
                maxoccuring=i;
            }

        }
        
        return maxoccuring;
    }
    
}