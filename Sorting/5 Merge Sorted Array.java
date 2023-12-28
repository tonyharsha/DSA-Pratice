class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //TC O(N+M)
        //SC O(N+M)
        
        int res[]=new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                res[k++]=nums1[i++];
            }else{
                res[k++]=nums2[j++];
            }
        }

        while(i<m){
            res[k++]=nums1[i++];
        }

        while(j<n){
            res[k++]=nums2[j++];
        }

        for(int l=0;l<nums1.length;l++){
            nums1[l]=res[l];
        }
        

        //TC O(N+M)
        //SC O(1)

        int i=m-1;
        int j=n-1;
        int l=m+n-1;
        while(j>=0){
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[l--]=nums1[i--];
            }else{
                nums1[l--]=nums2[j--];
            }
        }
    }
}