

import java.util.*;
import java.io.*;
//TC O(N^2)
//SC O(1)
class Solution
{
    //Function to sort the array using bubble sort algorithm.
	public static void bubbleSort(int arr[], int n)
    {
        //iteration
        //For optimization
        
        for(int i=0;i<n;i++){
            boolean flag=false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            if(flag==false) break;
        }
         
		 
        //Recursive.
        bubbleSortRec(arr,n);
        
    }
    
    public static void bubbleSortRec(int arr[],int n){
        if(n<=0) return;
        
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        bubbleSortRec(arr,n-1);
    }
}