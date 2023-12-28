class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        
        //This problem can also be solved via HashSet also.
		
		//Used Merge approach to solve the problem.
        ArrayList<Integer> result=new ArrayList<>();
        int i=0;
        int j=0;
        
        while(i<n && j<m){
			//imp to skip duplicates
            if(i>0 && arr1[i]==arr1[i-1]) {
                i++;
                continue;
            }
			//imp to skip duplicates
            if(j>0 && arr2[j]==arr2[j-1]){
               j++;
               continue;
            } 
            
            if(arr1[i]>arr2[j]){
                result.add(arr2[j]);
                j++;
            }else if(arr1[i]<arr2[j]){
                result.add(arr1[i]);
                i++;
            }else{
                result.add(arr1[i]);
                i++;
                j++;
            }
        }
        
        while(i<n){
            if(i>0 && arr1[i]==arr1[i-1]){
                i++;
                continue;
            }
            result.add(arr1[i]);
            i++;
        }
        
        while(j<m){
            if(j>0 && arr2[j]==arr2[j-1]){
                j++;
                continue;
            }
            result.add(arr2[j]);
            j++;
        }
        
        return result;
    }
}