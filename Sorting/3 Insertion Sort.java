//TC O(N^2)
//SC O(1)
//Preffered to used when N is smaller in value.

//The Main Concept is after one iteration till i [Meant the sub-array from 0 to i) must be sorted.
//Every element is sorted for its own position.
class Solution
{
  public void insertionSort(int nums[], int n)
  {
      for(int i=1;i<n;i++){
          int key=nums[i];
          int j=i-1;
          while(j>=0 && nums[j]>key){
              nums[j+1]=nums[j];
              j--;
          }
          nums[j+1]=key;
      }
  }
}