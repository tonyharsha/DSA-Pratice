//TC O(N*K)
//SC O(1)

class Solution
{
    void leftRotate(long arr[], int k,int n)
    {
        
        for(int i=1;i<=k;i++){
            rotate(arr);
        }
    }
    void rotate(long arr[]){
        long first=arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1]=first;
    }
}



//TC O(2N)~O(N)
//SC O(1)

//reverse first K-1 element
//reverse from K to N
//reverse full array this will give the left rotated array of K times
class Solution
{
    void leftRotate(long arr[], int k,int n)
    {
        
        k=k%n;
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);
    }
    
    void reverse(long arr[],int start,int end){
        while(start<end){
            long temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}