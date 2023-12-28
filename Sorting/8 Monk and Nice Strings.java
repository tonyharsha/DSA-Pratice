class Solution {
	public int[] niceStrings(String[] A) {
		// Your code goes here
		int res[]=new int[A.length];
		for(int i=0;i<A.length;i++){
			int count=0;
			for(int j=i-1;j>=0;j--){
			//.compareTo=> will give integer diff n/w first and last eg: c.compareTo(a)=> 2 
				if(A[i].compareTo(A[j])>0){
					count++;
				}
			}
			res[i]=count;
		}
		return res;
	}
}