class Solution {
	 //M =>Alice.length() N=Bob.length.
	 //TC O(MLogM)=>Binary search +O(N) => Traversing
	 //SC O(MLogM) +(NLogN)  => Sorting 
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum=0;
        int bobSum=0;

        //alice Array Sum
        for(int i=0;i<aliceSizes.length;i++){
            aliceSum+=aliceSizes[i];
        }

        //Bob Array Sum
        for(int i=0;i<bobSizes.length;i++){
            bobSum+=bobSizes[i];
        }
     
        //Total sum
        int totalsum=aliceSum+bobSum;

        //Sorting because we will use binary serach to find elements to be swapped.
        Arrays.sort(aliceSizes);
        Arrays.sort(bobSizes);

        for(int i=0;i<aliceSizes.length;i++){
            //fincalculating the target element to be searched in bob array.
            int k=(totalsum/2)-(aliceSum-aliceSizes[i]);
            if(BinarySearch(bobSizes,k)){
                return new int[]{aliceSizes[i],k};
            }
        }
        return new int[]{-1,-1};


    }

    public boolean BinarySearch(int arr[],int k){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==k) return true;
            else if(arr[mid]>k){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return false;
    }
}