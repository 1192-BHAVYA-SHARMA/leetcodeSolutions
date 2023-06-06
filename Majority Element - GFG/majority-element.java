//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
         HashMap<Integer,Integer>hs=new HashMap<>();
         for(int i=0;i<size;i++){
             if(!hs.containsKey(a[i])){
                 hs.put(a[i],1);
                 
             }else{
                 hs.put(a[i],hs.get(a[i])+1);//  here increment the value
                 }
        }
        for(Map.Entry<Integer,Integer> e : hs.entrySet()){
            if(e.getValue()>size/2){
                return e.getKey();}
            
        }
        return -1;
    }
}