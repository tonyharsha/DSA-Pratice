class Solution {
    public int[][] reconstructQueue(int[][] people) {
       //Yhe main idea is to sort in descending order of 0th index.
       //If in case 0th index is same then sort in ascending order of 1th index.
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0])
              return a[1]-b[1];
            return b[0]-a[0];
        });

        //[7,0] [7,1] [6,1] [5,0] [5,2] [4,4]
        List<int []> res=new LinkedList<>();
        
        //To get the right answer insert the element in 1th index.
        for(int i[]:people){
            res.add(i[1],i);
        }
   
        return res.toArray(new int[res.size()][]);
        
        
    }
}