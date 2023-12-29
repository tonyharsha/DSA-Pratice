class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        int start=intervals[0][0];
        int end=intervals[0][1];
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=end){
                end=Math.max(end,intervals[i][1]);
            }else{
                ArrayList<Integer> cur=new ArrayList<>();
                cur.add(start);
                cur.add(end);
                res.add(cur);
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        ArrayList<Integer> cur=new ArrayList<>();
        cur.add(start);
        cur.add(end);
        res.add(cur);

        int result[][]=new int[res.size()][res.get(0).size()];
        for(int i=0;i<res.size();i++){
            for(int j=0;j<res.get(i).size();j++){
                result[i][j]=res.get(i).get(j);
            }
        }

        return result;
    }
}