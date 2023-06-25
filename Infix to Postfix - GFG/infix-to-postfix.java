//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static int prec(char ch)
    {
        if(ch =='+' || ch=='-')
            return 1;
        else if(ch =='*' || ch=='/')
            return 2;
        else if(ch=='^')
            return 3;
        else
            return -1;
    }
    public static String infixToPostfix(String exp) {
        // Your code here
         String res = "";
        ArrayDeque<Character>s = new ArrayDeque<Character>();
        for(int i=0;i<exp.length();i++)
        {
            char ch = exp.charAt(i);
            
            if(Character.isLetterOrDigit(ch))
                res += ch;
            else if(ch == '(')
                s.push(ch);
            else if(ch == ')')
            {
                while(!s.isEmpty() && s.peek()!='(')
                    res += s.pop();
                s.pop();
            }
            else
            {
                while(!s.isEmpty() && prec(ch)<=prec(s.peek()))
                {
                    res += s.pop();
                }
                s.push(ch);
            }
        }
        while(s.isEmpty() == false)
        {
            if(s.peek() == '(')
            {
                res = "Invalid";
            }
            else
            {
                res += s.pop();
            }
        }
        return res;
    }
}