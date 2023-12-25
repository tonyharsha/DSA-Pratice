class Solution {
    //TC O(N^2)+ O(Nlog N)
    //SC O(1).
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;){
            int sum=0-nums[i];
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]==sum){
                    List<Integer> output=new ArrayList<>();
                    output.add(nums[i]);
                    output.add(nums[j]);
                    output.add(nums[k]);
                    result.add(output);

                    //Skipping if element present at index of j is repeated.
                    int eleAtJ=nums[j];
                    while(j<k && nums[j]==eleAtJ){
                        j++;
                    }

                    //Skipping if element present at index of k is repeated.
                    int eleAtK=nums[k];
                    while(j<k && nums[k]==eleAtK){
                        k--;
                    }
                }

                else if(nums[j]+nums[k]>sum){
                    k--;
                }else{
                    j++;
                }
            }

            //Skipping if element present at index of i is repeated.
            int eleAtI=nums[i];
            while(i<nums.length && nums[i]==eleAtI){
                i++;
            }
        }
        return result;
    }
}