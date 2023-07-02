//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
     
      Solution obj = new Solution();
      long ans = obj.count(n);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static long count(int n) {
    // code here
    //total edges possible 
        /*since every node can be connected to n-1 other nodes so for n nodes 
        total edges possible are n*(n-1) OR n*n(if self node is allowed) but
        since here undirected graph is being considered so edge from a to 
        b would be same as edge from b to a and hence divided by 2;
        */
        //int total_edges=n*(n-1)/2;
        //now for every edge we have two options whether to consider it or not 
        //return 1ll*pow(2,total_edges);
        //return 1LL<<(n*(n-1)/2);
       return (long)Math.pow(2,n*(n-1)/2);

  }
}
