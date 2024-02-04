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
class Solution {
    class pair{
        int val;
        int row;
        public pair(int val,int row){
            this.val=val;
            this.row=row;
        }

        public int getval(){
            return this.val;
        }

        public int getrow(){
            return this.row;
        }
    }
    // The Main logic goes this way
    // Add all the elements to TreeMap with respect to their rows and columns.
    // Key=> col and value=> pair{val,row}.
    // To get the answer we need to perform three level of sorting.
    // Sort the Map in ascending order of col.
    // Since TreeMap stores the values in sorted order so choose the TreeMap.
    // Then If the values in list are of same row and same column.
    // Sort it based on row  and if rows are also same
    // Sort it by their actual values.
    // Total Three level of Sort.
    // Col -> Row-> Value.
    TreeMap<Integer,List<pair>> tm=new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        process(root,0,0);
        List<List<Integer>> res=new ArrayList<>();

        //Sorting.
        //pair::getKey This will sort Pair class based on return type of getkey 
        Comparator<pair> valCompare=Comparator.comparing(pair::getval);
        Comparator<pair> rowCompare=Comparator.comparing(pair::getrow);
        Comparator<pair> multiCompare=rowCompare.thenComparing(valCompare);

       

        for(Map.Entry<Integer,List<pair>> e:tm.entrySet()){
            //We are sorting the list of pair for respective column.
             Collections.sort(e.getValue(),multiCompare);
             List<Integer> l=new ArrayList<>();
             for(pair i:e.getValue()){
                 l.add(i.getval());
             }
             res.add(l);
        }

        return res;
    }

    public void process(TreeNode root,int row,int col){
        if(root!=null){
            if(tm.containsKey(col)){
                tm.get(col).add(new pair(root.val,row));
            }else{
                List<pair> l=new ArrayList<>();
                l.add(new pair(root.val,row));
                tm.put(col,l);
            }
            process(root.left,row+1,col-1);
            process(root.right,row+1,col+1);
        }
    }
}