class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //TC O(KlogK)  K=M+N.
        //SC O(K)
        int n=nums1.length;
        int m=nums2.length;
        int res[]=new int[m+n];
        for(int i=0;i<n;i++){
            res[i]=nums1[i];
        }
        
        for(int i=n;i<m+n;i++){
            res[i]=nums2[i-n];
        }

        Arrays.sort(res);
        int mid=(m+n)/2;

        if((m+n)%2!=0) return (double) res[mid];

        double sum=res[mid]+res[mid-1];
        double ans= sum/2;
        return ans;

        //can also be sloved using Binary search.
    }
}