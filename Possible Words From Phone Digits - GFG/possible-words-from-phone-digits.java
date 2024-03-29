//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class PhoneDigit
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//testcases
        
        
        while(t-- > 0)
        {
            int n = sc.nextInt(); // input size of array
            int arr[] = new int[n]; //input the elements of array that are keys to be pressed
            
            for(int i = 0; i < n; i++)
               arr[i] = sc.nextInt();//input the elements of array that are keys to be pressed
            ArrayList <String> res = new Solution().possibleWords(arr, n);
            for (String i : res) System.out.print (i + " ");
             System.out.println();
              
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here
        List <String> list = Arrays.asList("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
        ArrayList <String> result = new ArrayList<>();
        possiblity(a, N, 0, "", list, result);
        return result;
    }
    private static void possiblity(int a[], int N, int i, String s, 
    List <String> list, ArrayList <String> result){
        if(i==N){
            result.add(s);
            return;
        }
        String str= list.get(a[i]);
        for(int j=0;j<str.length();j++){
            possiblity(a,N,i+1,s+str.charAt(j),list,result);
        }
    }
}


