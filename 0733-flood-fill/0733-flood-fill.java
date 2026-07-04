class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ogcolor = image[sr][sc];
        if(color == ogcolor)
        {
            return image;
        }
       dfs(image , sr , sc , ogcolor , color);
       return image ;
    }

    public void dfs(int[][] image ,int r , int c , int ogcolor , int newcolor)
    {
        if(r<0 || c < 0 || r>=image.length || c>=image[0].length)
        {
            return ;
        }
        if(image[r][c] != ogcolor)
        {
            return ;
        }

        image[r][c] = newcolor;

        dfs(image ,r-1 , c , ogcolor , newcolor );//up
        dfs(image , r+1 , c , ogcolor , newcolor);// down
        dfs(image , r , c-1 , ogcolor , newcolor); // left
        dfs(image , r ,c+1 , ogcolor , newcolor); // right
    }
}