//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        // code here 
        
        /*Dutch national flag algorithm
        APPROACH: Three pointers --> left,mid,right
initially left and right are pointed to both the ends of the array respectively
mid points towards start initially
program lasts until mid reaches other end of the array
case 1: if mid encounters -> 0
        swap arr[mid] , arr[left] 
        increment left and mid by one/ move both left and 
        right pointers right side by one
case 2:if mid encounters -> 1
    simply increment mid by 1/move mid pointer right by one
case 3: (last case) if mid encounters -> 2
swap arr[mid],arr[right]
decrement only right by one / move right pointer left side by one
    */
    int left=0,mid=0,right=n-1;
    while(mid<=right){
        if(a[mid]==0){
            swap(a,mid,left);
            mid++;
            left++;
        }
        else if(a[mid]==1){
            mid++;
        }
        else if(a[mid]==2){
            swap(a,mid,right);
            right--;
        }
    }
    }
    public static void swap (int a[], int f ,int e){
        int temp = a[f];
        a[f]=a[e];
        a[e]=temp;
    }
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends