class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        //can be solved using HashSet also.

        //Solved using Merge Approach/Two pointer approach.
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n=nums1.length;
        int m=nums2.length;
        ArrayList<Integer> resList=new ArrayList<>();

        int k=0;
        int i=0;
        int j=0;
        while(i<n&&j<m){
            //imp avoiding duplicate values.
            if(i>0 && nums1[i]==nums1[i-1]){
                i++;
				continue;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                resList.add(nums1[i]);
                i++;
                j++;
            }
        }
        int result[]=new int[resList.size()];
        for(int l=0;l<resList.size();l++){
            result[l]=resList.get(l);
        }
        return result;
    }
}