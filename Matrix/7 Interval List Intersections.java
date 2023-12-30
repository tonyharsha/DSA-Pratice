class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int  []>res=new ArrayList<>();

        int i=0;
        int j=0;
        while(i<firstList.length && j<secondList.length){
            
            //Main condition checking if interction is present are not.
            if(firstList[i][0]<=secondList[j][1] && firstList[i][1]>=secondList[j][0]){
                int start=Math.max(firstList[i][0],secondList[j][0]);
                int end=Math.min(firstList[i][1],secondList[j][1]);
                res.add(new int[]{start,end});
            }

            if(firstList[i][1]<secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
        
    }
}