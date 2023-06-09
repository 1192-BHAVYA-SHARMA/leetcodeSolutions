//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	public int findK(int a[][], int n, int m, int k)
	{
	    // Your code goes here
	    int i,top=0,left=0,right=m-1,bottom=n-1,count=1,result=0;
	    boolean flag=false;
        while(top<=bottom && left<=right){
            for(i=left;i<=right;i++){ //move right
                if(count==k){
                    flag=true;
                    result=a[top][i];
                    break;
                }
                count++;
            }
            if(flag==true) break;
            top++;
            for(i=top;i<=bottom;i++){ //move down
                if(count==k){
                    flag=true;
                    result=a[i][right];
                    break;
                }
                count++;
            }
            if(flag==true) break;
            right--;
            if(top<=bottom){ // moving left
                for(i=right;i>=left;i--){
                    if(count==k){
                        flag=true;
                        result=a[bottom][i];
                        break;
                    }
                    count++;
                }
            }
            if(flag==true) break;
            bottom--;
            if(left<=right){ // moving top
                for(i=bottom;i>=top;i--){
                    if(count==k){
                        flag=true;
                        result=a[i][left];
                        break;
                    }
                    count++;
                }
            }
            if(flag==true) break;
            left++;
        }
        return result;
	}
	
}