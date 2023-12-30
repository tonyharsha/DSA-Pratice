class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        //The logic is first find min in each row and add to HashMap.
        //Then find the max in each column and add to HashMap
        //Now if any element in hashmap contains more than one has count
        //Then they are lucky number.
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        ArrayList<Integer> res=new ArrayList<>();

        for(int i=0;i<matrix.length;i++){
            int min=matrix[i][0];
            for(int j=0;j<matrix[0].length;j++){
                min=Math.min(min,matrix[i][j]);
            }
            hm.put(min,hm.getOrDefault(min,0)+1);
        }
        
        for(int i=0;i<matrix[0].length;i++){
            int max=matrix[0][i];
            for(int j=0;j<matrix.length;j++){
                max=Math.max(max,matrix[j][i]);
            }
            hm.put(max,hm.getOrDefault(max,0)+1);
            if(hm.get(max)>1){
                res.add(max);
            }
        }

        return res;
    }
}