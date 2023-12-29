class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        
        Collections.sort(a);
        long min=Long.MAX_VALUE;
        for(int i=m-1;i<n;i++){
            //IMP
            min=Math.min(min,a.get(i)-a.get(i-m+1));
        }
        return min;
        
    }
}