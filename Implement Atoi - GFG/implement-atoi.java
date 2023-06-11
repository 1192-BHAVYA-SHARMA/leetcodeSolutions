//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	// Your code here
	int num = 0;
	int sign = 1;
	return convert(str,num,0,sign);
    }
    int convert(String str,int num,int i,int sign){
        if(i==str.length())
            return sign * num;
        char c = str.charAt(i);
        if(c-'0' >= 0 && c-'0' <= 9){
            int newNum = num * 10 + (c-'0');
            return convert(str,newNum,i+1,sign);
        }else if(i == 0 && c == '-'){
            return convert(str,num,i+1,-1);
        }else
            return -1;
    }
}
