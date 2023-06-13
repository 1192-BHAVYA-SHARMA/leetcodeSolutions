//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.maxOdd(s));
        }
    }
}
// } Driver Code Ends


class Solution {

    String maxOdd(String s) {
        // code here
        //Check unit digit 
        //If it is odd then return substring from 0 to till trigered position 
        int j = s.length()-1;
        while(j>=0){
            if(Character.getNumericValue(s.charAt(j))%2!=0){
                return s.substring(0,j+1);
            }
            j--;
        }
        
        return "";
    }
}