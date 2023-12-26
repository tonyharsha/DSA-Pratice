class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
		
		//can be done using HashSet/HashMap But SC O(N).
		
		
        //TC O(N)
        //SC O(1)
        
        //Here using % n so index will be within range.
        for(int i=0;i<n;i++){
            arr[arr[i]%n]=arr[arr[i]%n]+n;
        }
        
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]/n>1){
                res.add(i);
            }
        }
        if (res.size()==0) res.add(-1);
        return res;
    }
}