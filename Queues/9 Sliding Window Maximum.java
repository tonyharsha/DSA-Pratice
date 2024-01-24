class Solution {
    //TC O(N)
    //Sc O(N)
	//using the technique of next greater element with little modification.
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        Deque<Integer> dq=new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && nums[i]>nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }

        res.add(nums[dq.getFirst()]);

        for(int i=k;i<nums.length;i++){
            while(!dq.isEmpty() && dq.getFirst()<=(i-k)){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[i]>nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);

            res.add(nums[dq.getFirst()]);

        }
        
        int resarr[]=new int[res.size()];
        for(int i=0;i<res.size();i++){
            resarr[i]=res.get(i);
        }
        return resarr;
        
        
    }
}