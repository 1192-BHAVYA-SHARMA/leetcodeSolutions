//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vist[] = new boolean[V];
        for(int i=0;i<V;i++){ // checking all possible nodes
            if(!vist[i]){ // which are not visited
                if(dfs(i,vist,adj)){ // if there is a cycle
                    return true;
                }
            }   
        }
        return false; // else no cycle present
    }
    private class Pair{
        int node,parent;
        Pair(int node, int parent){
            this.node=node; // current node
            this.parent=parent; // holds calling parent node
        }
    }
    private boolean dfs(int src, boolean vst[]
                ,ArrayList<ArrayList<Integer>> adj)    {
        
        Stack<Pair> st=new Stack<>(); // stack to maintain the calling order
        st.push(new Pair(src, -1)); // the source would have no parent
        while(st.isEmpty()==false){
            Pair top = st.pop();
            vst[top.node]=true;
            // System.out.printf("%d->",top.node);
            Iterator<Integer> it = adj.get(top.node).iterator();
            while(it.hasNext()){
                int nighbour=it.next();
                if(nighbour!=top.parent){ // parent ---- neighbour is not cycle
                    if(vst[nighbour])  
                        return true; // got a node already visted once hence cycle
                    st.push(new Pair(nighbour,top.node)); // pushing every new neighbour
                }
            }
        }
       return false; // no cycle detected
    }

}