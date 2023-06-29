//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    //Function to count number of ways to reach the nth stair.
    int countWays(int n)
    {
        //base condition
        
        if(n<3)
        return n;
        int md=(int)Math.pow(10,9)+7;
        int s1=1;
        int s2=2;
        int s3=0;
        int i=3;
        while(i<=n){
            s3=(s1+s2)%md;
            s1=s2;
            s2=s3;
            i++;
        }
        return s3%md;
    }
}

