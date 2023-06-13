//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
         if(arr.length==0){
              return "-1";}
              //let asssume the longest prefix will be 
              //dont confuse if the first string is the smallest also then 
             //it will not goona harm maximu prefix lenght will be equla to that much lenght 
        String prefix=arr[0]; 
        //now start from the loop 1 to n 
        //anc check whther any of the string constians as a prefix as if it
        //contains then indexOf will must have equal to 0
        for(int i=1;i<arr.length;i++){
            while(arr[i].indexOf(prefix)!=0){ //age se length ghatwa
            prefix=prefix.substring(0,prefix.length()-1);
            if(prefix.isEmpty())
            return "-1";
        }
    }
    return prefix;
    }
}