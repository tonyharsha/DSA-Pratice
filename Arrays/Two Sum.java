//Brute Force
//TC O(N^2)
//TC O(1).

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sum=0;
        int res[]=new int[2];
        for(int i=0;i<nums.length;i++){
            sum=nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(sum+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                    break;
                }
            }
        }
        return res;
    }
}

//optimal
//TC O(N)
//SC O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int res[]=new int[2];
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                res[0]=hm.get(target-nums[i]);
                res[1]=i;
                break;
            }else{
                hm.put(nums[i],i);
            }
        }
        return res;

    }
}