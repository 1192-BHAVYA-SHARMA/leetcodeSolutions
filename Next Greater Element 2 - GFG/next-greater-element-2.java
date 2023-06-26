//{ Driver Code Starts
// Initial Template for Java

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
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans[] = obj.nextGreaterElement(n, a);
            for (int e : ans) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*Step 1: Store all the element in the stack.
(Note: start pushing element in stack, from the end of the arr) 
Eg. arr = [ 5, 4, 3, 2, 1] then stack.push(1), stack.push(2), ... , 
stack.push(5)
Step 2: Define a new array "res" which have -1 at all indexes.
Step 3: Now, iterate through the array "arr", starting from end of array,
and check if stack top element is less than the arr[i] then pop the element, 
using while loop.
Once the stack top is greater than arr[i] then res[i] = stack.peek().
If stack become empty in the while loop then just move on it mean there is 
no element greater than the arr[i].
Now, at last just push the arr[i] in the stack so that we can have it for 
comparison in the next iteration.*/

class Solution {
    static int[] nextGreaterElement(int N, int arr[]) {
        // code here
        Stack<Integer> s = new Stack<>();
        for(int i = N-1; i >= 0; i--){
            s.push(arr[i]);
        }
        int[] res = new int[N];
        Arrays.fill(res, -1);
        for(int i = N-1; i >= 0; i--){
            while(!s.isEmpty() && arr[i] >= s.peek()){
                s.pop();
            }
            if(!s.isEmpty()) res[i] = s.peek();
            s.push(arr[i]);
        }
        return res;
    }
}
