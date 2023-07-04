//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        // topDown Approach
        //return topDown(arr, n);
        // bottomUp Approach
        // return bottomUp(arr, n);
        // Space Otimized Approach
        return spaceOpt(arr, n);
    }
    int solve(int[] dp, int[] arr, int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return arr[n - 1];
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        // take
        int taken = arr[n - 1] + solve(dp, arr, n - 2);
        
        // not taken
        int notTaken = solve(dp, arr, n - 1);
        
        return dp[n] = Math.max(taken, notTaken);
    }
    int topDown(int[] arr, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(dp, arr, n);
    }
    
    int bottomUp(int[] arr, int n) {
        int[] dp = new int[n + 1];
        dp[1] = arr[0];
        
        for (int i = 2; i <= n; i++) {
            int taken = arr[i - 1] + dp[i - 2];
            int notTaken = dp[i - 1];
            dp[i] = Math.max(taken, notTaken);
        }
        
        return dp[n];
    }
    
    int spaceOpt(int[] arr, int n) {
        int pre1 = 0, pre2 = arr[0];
        
        for (int i = 2; i <= n; i++) {
            int taken = arr[i - 1] + pre1;
            int notTaken = pre2;
            int curr = Math.max(taken, notTaken);
            pre1 = pre2;
            pre2 = curr;
        }
        
        return pre2;
    }
}