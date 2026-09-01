class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0)return false ;

        int[][] pos = new int[n*n][2];

        for(int r=0;r<n;r++)
        {
            for(int c=0;c<n;c++)
            {
                pos[grid[r][c]][0] = r;
                pos[grid[r][c]][1] = c;

            }
        }

        for(int i=1;i<n*n;i++)
        {
            int r1 = pos[i-1][0];
            int c1 = pos[i-1][1];

            int r2 = pos[i][0];
            int c2 = pos[i][1];

            int dr = Math.abs(r1-r2);
            int dc = Math.abs(c1-c2);

            if(!((dr==2 && dc ==1) || (dr==1 && dc ==2)))return false ;
        }

        return true ;
    }
}