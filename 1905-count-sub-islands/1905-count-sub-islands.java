class Solution {
    int m ;
    int n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid2.length;
        n = grid2[0].length;

        int count =0;

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid2[i][j] ==1)
                {
                    if(dfs(i , j , grid1 , grid2))count++;
                }
            }
        }
        return count ;
    }

    private boolean dfs(int r , int c , int[][] grid1 , int[][] grid2)
    {
        
        if(r<0 || r>=m || c<0 || c>=n)return true ;
        if(grid2[r][c] ==0)return true ;

        grid2[r][c] = 0;


        boolean isSubisland = grid1[r][c] ==1 ;

        boolean up = dfs(r-1 , c , grid1 , grid2);
        boolean down = dfs(r+1 , c , grid1 , grid2);
        boolean right = dfs(r , c+1 , grid1 , grid2);
        boolean left = dfs(r , c-1, grid1 , grid2);

        return isSubisland && up && right && left && down ;


    }
}