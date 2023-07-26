//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        // Your code here
        // left pointer and right pointer, leftSum and rightSum
        // increment the pointer whose sum is small
        // if sum is same and left + 2 == right, we found the equilibriam point
        
        if (n == 1) return 1;
        if (n == 2) {
            if (arr[1] == 0) return 1;
            else if (arr[0] == 0) return 2;
            else return -1;
        }
        
        int left = 0, right = n-1;
        long leftSum = arr[left], rightSum = arr[right];
        
        while (right - left > 2) {
            if (leftSum < rightSum) {
                left++;
                leftSum += arr[left];
            } else {
                right--;
                rightSum += arr[right];
            }
            
            
            if (right - left == 2 && leftSum == rightSum)
                return left + 2;
        }
        
        return -1;
        
    }
}
