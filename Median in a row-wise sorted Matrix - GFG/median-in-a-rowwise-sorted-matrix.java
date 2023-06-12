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
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        // code here   
        // Binary Search    
        int low = 0, high = 2000;
        while(low <= high){
            int mid = (low + high) / 2;
            int count = 0;
            for(int i = 0; i < R; i++)
                count += valCount(matrix , i, mid);
            if(count <= (R * C) / 2) 
                low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    // Binary Search to find element count less than val
    int valCount(int matrix[][], int i, int val){
        int l = 0, r= matrix[i].length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(matrix[i][mid] <= val)
                l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}