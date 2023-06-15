//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        int n = arr.length;
        int i =0;//index
        int c=0;//count of jumps made
        while(i<n-1){//bcz reach at end element
        
            if(arr[i] ==0){//cant move ahead
            return -1;}
            i+=jump(arr,i,n);//goes to new position 
            c++;//increment count 
        }
        return c;
    }
    static int jump(int [] arr, int i ,int n ){
        int steps = arr[i];
        int ans=1;
        if(i+steps >= n-1){return steps;}//agr value passing condition pr h 
        //then simply return steps
        for(int j=1;j<= steps;j++){
            //decide no of steps actually taken
            if(j+arr[i+j] > ans+arr[i+ans] &&  arr[i+j] !=0){
                ans =j;
            }
        }
        return ans;
    } 
}