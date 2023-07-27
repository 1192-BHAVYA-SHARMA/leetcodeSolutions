//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        //Sorting on the basis of departures 
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int array[] = new int[2];
            array[0] = arr[i];
            array[1] = dep[i];
            list.add(array);
        }

        Collections.sort(list, new Comparator<int[]>(){

            public int compare(int a[], int b[]){
                if(a[0]!=b[0]){
                    return a[0] - b[0];
                }
                else {
                    return a[1] - b[1];
                }
            }
        });
        int maxPlatForms = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            
            while(!queue.isEmpty() && list.get(i)[0] > queue.peek()){
                queue.poll();
            }
            
            if(queue.isEmpty()){
                queue.add(list.get(i)[1]);
            }
            else if(queue.peek() >= list.get(i)[0]){
                queue.add(list.get(i)[1]);
            }
            
            maxPlatForms = Math.max(maxPlatForms, queue.size());
        }
        return maxPlatForms;
        
    }
    
}

