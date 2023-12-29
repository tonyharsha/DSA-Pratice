class Solution
{
    public static void sort012(int a[], int n)
    {
        int start=0;
        int end=n-1;
        int mid=0;
		//mid is used as looping variable.
        while(mid<=end){
            if(a[mid]==0){
                int temp=a[start];
                a[start]=a[mid];
                a[mid]=temp;
                start++;
                mid++;
            }else if(a[mid]==1) {
                mid++;
            }
            else{
               int temp=a[end];
               a[end]=a[mid];
               a[mid]=temp;
               end--;
            }
        }
    }
}