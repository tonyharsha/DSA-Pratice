/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 //TC O(N^2)
 //SC O(logN) Recursion Stack
 // This logic is very simple the only change is we recursively running the code for every node
 // considering it as the root node..
class Solution {
    int res=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root!=null){
            helper(root,targetSum);
            pathSum(root.left,targetSum);
            pathSum(root.right,targetSum);
        }
        return res;
    }

    public void helper(TreeNode root,long targetSum){
        if(root!=null){
            if(targetSum==root.val) res++;
            helper(root.left,targetSum-root.val);
            helper(root.right,targetSum-root.val);
        }
    }
}

//O(n) via hashMap
 //PrefixSum, RunningSum and HasHMap stores the no of times the running sum is present in tree.
 //Count of targetSum=== Hm.getCount(RunningSum-TargetSum)
 //(x+y+z) -(y+z) => x
class Solution {
    int count=0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> hm=new HashMap<>();
        //This line is very imp to keep track of path that includes root to leaf
        //So diff will be zero and if zero not in hashmap that count will not be considered.
        //To cover that case we insert 0 with count 1.
        hm.put(0l,1);
        pathSum(root,targetSum,0l,hm);
        return count;
    }

    public void pathSum(TreeNode root,int targetSum,Long runningSum,HashMap<Long,Integer>hm){
        if(root!=null){
            runningSum+=root.val;
            if(hm.containsKey(runningSum-targetSum)){
                //Here we are getting the count of num present beacause for every calls
                //Count of partcular num will increase or decrease.
                //If i dont consider the frequency of repetation
                //It will fail few cases
                /*
                    [1,-2,-3]
                    targetSum =-1
                    Use Testcase
                    Output
                    2
                    Expected
                    1
                */
                count+=hm.get(runningSum-targetSum);
            }
            hm.put(runningSum,hm.getOrDefault(runningSum,0)+1);

            pathSum(root.left,targetSum,runningSum,hm);
            pathSum(root.right,targetSum,runningSum,hm);
            //backTracking.
            hm.put(runningSum,hm.get(runningSum)-1);


        }
    }
}