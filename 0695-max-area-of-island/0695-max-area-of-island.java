class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int area = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] ==1  && !visited[i][j])
                {
                    area = Math.max(area , dfs(grid , m , n , i , j , visited));
                }
            }
        }
        return area ;
    }

    public int dfs(int[][] grid , int m , int n , int r , int c , boolean[][] vis)
    {
        if(r<0 || c<0 || r>=m || c>=n)return 0;

       if (grid[r][c] == 0 || vis[r][c])
    return 0;

        vis[r][c] = true ;

        return 1 + dfs(grid , m ,n , r+1 ,c, vis) + dfs(grid , m ,n , r-1 ,c, vis)+dfs(grid , m ,n , r ,c+1, vis)+dfs(grid , m ,n , r ,c-1, vis );
    }
}