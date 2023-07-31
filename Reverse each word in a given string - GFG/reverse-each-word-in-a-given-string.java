//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.reverseWords (s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
   
    String reverseWords(String S)
    {
        // your code here
        /*Stack<Character> st = new Stack<>();
        String s="";
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='.'){
              while(!st.isEmpty()){s=s+st.pop();} 
              s=s+".";
            }
            else{
                st.push(S.charAt(i));
            }
        }
        while(!st.isEmpty()){s=s+st.pop();}
        return s;*/
        Stack<Character> st=new Stack<>();// p,q,r 
     StringBuilder str=new StringBuilder();//
     
     for(int i=0;i<S.length();i++){
         if(S.charAt(i)!='.'){
             st.push(S.charAt(i));
         }else{
             while(!st.isEmpty()){
                 str.append(st.pop());
             }
             str.append('.');
         }
     }
     while(!st.isEmpty()){
         str.append(st.pop());
     }
    return str.toString();
        
        
    }
    
}