//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends

class Pair{
    int x;
    int y;
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}
class Solution
{
     public void bfs(int image[][],boolean vis[][],int sr,int sc,int newColor,int oldColor){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sr,sc));
        vis[sr][sc]=true;
        while(!q.isEmpty()){
            Pair front=q.poll();
            int x=front.x;
            int y=front.y;
            image[x][y]=newColor;
            if(x>0 && !vis[x-1][y] && image[x-1][y]==oldColor){
                q.add(new Pair(x-1,y));
                vis[x-1][y]=true;
            }
            if(y>0 && !vis[x][y-1] && image[x][y-1]==oldColor){
                q.add(new Pair(x,y-1));
                vis[x][y-1]=true;
            }
            if(x<image.length-1 && !vis[x+1][y] && image[x+1][y]==oldColor){
                q.add(new Pair(x+1,y));
                vis[x+1][y]=true;
            }
            if(y<image[0].length-1 && !vis[x][y+1] && image[x][y+1]==oldColor){
                q.add(new Pair(x,y+1));
                vis[x][y+1]=true;
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        boolean vis[][]=new boolean[image.length][image[0].length];
        int oldColor=image[sr][sc];
        bfs(image,vis,sr,sc,newColor,oldColor); 
        return image;
    }
}