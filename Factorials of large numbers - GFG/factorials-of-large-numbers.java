//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
         ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int listSize = 1;
        for(int i = 2; i <= N; i++){
            listSize = multiply(i, list, listSize);
        }
        Collections.reverse(list);
        return list;
    }
    static int multiply(int x, ArrayList<Integer> list, int listSize){
        int carry = 0; int digit = 0;
        for(int i = 0; i < listSize; i++){
            digit = list.get(i) * x + carry;
            list.set(i, digit%10);
            carry = digit/10;
        }
        
        while(carry > 0){
            list.add(listSize, carry%10);
            carry = carry/10;
            listSize++;
        }
        return listSize;
    }
}