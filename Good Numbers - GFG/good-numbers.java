//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            int D = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.goodNumbers(L, R, D);
            for (int i : ans) System.out.print(i + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static boolean isGood(int num, int d, int curr){
        if(num==0){return true;}
        int rem = num%10;
        if(rem==d) {return false;}
        if(rem<=curr){ return false;}
        num/=10;
        if(curr==-1) {curr = rem;}
        else {curr+=rem;}
        return isGood(num, d, curr);

    }

    ArrayList<Integer> goodNumbers(int L, int R, int D) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=L; i<=R; i++){
            if(isGood(i,D,-1)) ans.add(i);
        }
        return ans;
    }
    
}