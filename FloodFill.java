//TC: O(m*n) where m is the number of rows, n is the number of columns
//SC: O(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Method 2- DFS
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor)
            return image;

        int m = image.length;
        int n = image[0].length;

        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0},{0,-1}};

        int color = image[sr][sc];
        dfs(image,sr,sc,newColor,m,n,dirs,color);
        return image;
    }


    private void dfs(int[][] image, int sr,int sc, int newColor, int m, int n, int[][] dirs,int color){

        //base case
        if(sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color)
            return;


        //logic
        image[sr][sc] = newColor;
        for(int[] dir : dirs){
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;

            dfs(image,nr,nc,newColor,m,n,dirs,color);
        }

    }
}

//Method 1 -  BFS
public class FloodFill {
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image[sr][sc] == newColor)
            return image;

        int m = image.length;
        int n = image[0].length;

        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0},{0,-1}};

        int color = image[sr][sc];

        Queue<Integer> q = new LinkedList<>();

        q.add(sr);
        q.add(sc);

        image[sr][sc] = newColor;

        while(!q.isEmpty()){

            int cr = q.poll();
            int cc = q.poll();

            for(int[] dir : dirs){
                int nr = dir[0] + cr;
                int nc = dir[1] + cc;

                //bound check
                if(nr >= 0 && nc >= 0 && nr < m && nc < n && image[nr][nc] == color){
                    q.add(nr);
                    q.add(nc);

                    image[nr][nc] = newColor;
                }
            }
        }
        return image;
    }
}