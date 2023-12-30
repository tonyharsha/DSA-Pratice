class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int i[]:rectangles){
            int value=Math.min(i[0],i[1]);
            hm.put(value,hm.getOrDefault(value,0)+1);
            max=Math.max(max,value);
        }

        return hm.get(max);
    }
}