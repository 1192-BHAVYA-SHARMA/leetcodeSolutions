//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        long mod = (long)1e9+7;
        ArrayList<ArrayList<Long>> result = new ArrayList<>();
        ArrayList<Long> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<Long> row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    row.add((long)1);
                }
                else{
                    row.add((result.get(i-1).get(j-1) + result.get(i-1).get(j))%mod);
                }
            }
            result.add(row);
        }
        for(int i=0;i<n;i++){
            ans.add(result.get(n-1).get(i));
        }
        return ans;
    }
}