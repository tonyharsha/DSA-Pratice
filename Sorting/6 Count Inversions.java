class Solution
{
    //TC O(NlogN)
	//SC O(N)
    static long inversionCount(long arr[], long N)
    {
       return MergeSort(arr,0,(int)N-1);
    }
    
    static long MergeSort(long arr[],int left,int right){
        long ans=0;
        if(left<right) {
            int mid=left+(right-left)/2;
            ans+=MergeSort(arr,left,mid);
            ans+=MergeSort(arr,mid+1,right);
            ans+=Merge(arr,left,mid,right);
        }
        return ans;
    }
    
    static long Merge(long arr[],int left,int mid,int right){
        int N1=mid-left+1;
        int N2=right-mid;
        
        long leftArray[]=new long[N1];
        long rightArray[]=new long[N2];
        
        for(int i=0;i<N1;i++){
            leftArray[i]=arr[left+i];
        }
        
        for(int i=0;i<N2;i++){
            rightArray[i]=arr[mid+i+1];
        }
        
         int i=0;
         int j=0;
         int k=left;
         long ans=0;
         
         
         while(i<N1 && j<N2){
             if(leftArray[i]<=rightArray[j]){
                 arr[k++]=leftArray[i++];
             }else{
                 //IMP.
                 ans+=N1-i;
                 arr[k++]=rightArray[j++];
             }
         }
         
         while(i<N1){
             arr[k++]=leftArray[i++];
         }
         
         while(j<N2){
             arr[k++]=rightArray[j++];
         }
         return ans;
    }
}