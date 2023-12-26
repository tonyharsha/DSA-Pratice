class Solution {
    public int majorityElement(int[] nums) {
        //TC O(N)
        //SC O(N) 
        
        int n=nums.length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        
        for(int key:hm.keySet()){
            if(hm.get(key)>(n/2)) return key;
        }

        return -1;
        

        //TC O(NlogN)
        //SC O(N)
        Arrays.sort(nums);
        return nums[nums.length/2];

        
    }
}