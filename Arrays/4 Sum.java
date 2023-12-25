class Solution {
    //TC O(N*(N-1)*(N-2))  ~ O(N^3)
    //SC O(1)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int m=0;m<nums.length;){
            long sum1=target-nums[m];// Using long to over come Integer Overflow case.
            for(int i=m+1;i<nums.length;){
            long sum2=sum1-nums[i];
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                long total=nums[j]+nums[k];
                if(total==sum2){
                    List<Integer> output=new ArrayList<>();
                    output.add(nums[m]);
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

                else if(total>sum2){
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
         //Skipping if element present at index of m is repeated.
            int eleAtI=nums[m];
            while(m<nums.length && nums[m]==eleAtI){
                m++;
            }

        }
        return result;
        
    }
}