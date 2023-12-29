class Solution
{   
    //TC O(N^2) worst case O(NlogN) Best case
	//SC Recursion stack.
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        // code here
        if(low<high){
            int index=partition(arr,low,high);
            quickSort(arr,low,index-1);
            quickSort(arr,index+1,high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        int povit=high;
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<arr[povit]){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=arr[i];
        arr[i]=arr[povit];
        arr[povit]=temp;
        
        return i;
    } 
}