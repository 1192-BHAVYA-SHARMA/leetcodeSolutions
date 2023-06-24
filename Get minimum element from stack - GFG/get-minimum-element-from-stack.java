//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    int minEle;
    Stack<Integer> s=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    // Constructor    
    GfG()
{
 
}
 
    /*returns min element from stack*/
    int getMin()
    {
        if(s2.isEmpty())
            return -1;
    return s2.peek();
    }
    
    /*returns poped element from stack*/
    int pop()
    {
        if(s.isEmpty())
            return -1;
    int val=s.pop();
    if(val==s2.peek())
        s2.pop();
    return val;
    }
 
    /*push element x into the stack*/
    void push(int x)
    {
        if(s2.isEmpty() || x<=s2.peek())
            s2.push(x);
    s.push(x);
    }
}