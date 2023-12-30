class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i[]:image){
            reverse(i);
        }
        return image;
        
    }

    public void reverse (int arr[]){
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }

        invert(arr);
    }

    public void invert(int arr[]){
        for(int i=0;i<arr.length;i++){
            arr[i]=(arr[i]==0)?1:0;
        }
    }
}