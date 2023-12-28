class Solution
{   
//TC O(NlogN)
//SC O(N).
    void merge(int arr[], int left, int mid, int right)
    {
         // Your code here
         int N1=mid-left+1;
         int N2=right-mid;
         
         int leftArray[]=new int[N1];
         int rightArray[]=new int[N2];
         
         for(int i=0;i<N1;i++){
             leftArray[i]=arr[left+i];
         }
         
         for(int i=0;i<N2;i++){
             rightArray[i]=arr[mid+1+i];
         }
         
         int i=0;
         int j=0;
		 //imp
         int k=left;
         
         
         while(i<N1 && j<N2){
             if(leftArray[i]<rightArray[j]){
                 arr[k++]=leftArray[i++];
             }else{
                 arr[k++]=rightArray[j++];
             }
         }
         
         while(i<N1){
             arr[k++]=leftArray[i++];
         }
         
         while(j<N2){
             arr[k++]=rightArray[j++];
         }
         
    }
    void mergeSort(int arr[], int l, int r)
    {
        if(l<r){
            int mid=l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }
}