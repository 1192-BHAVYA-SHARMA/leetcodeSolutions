//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] price = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                price[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            sln.stockBuySell(price, n);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void stockBuySell(int[] price, int n) {
        // code here
        int low = 0;
        int high = 0;
        int flag = 0;
        for(int i=1;i<n;i++){
            if(price[i]>price[i-1]){
                high=i;
            }else if(low!=high){
                System.out.print("("+low+" "+high+")"+" ");
                flag=1;
                low=high=i;
            }else{
                low=high=i;
            }
        }
        if(low!=high){
            System.out.print("("+low+" "+high+")");
            flag=1;
        }
        if(flag==0){
            System.out.print("No Profit");
        }
        System.out.println();

    }
}