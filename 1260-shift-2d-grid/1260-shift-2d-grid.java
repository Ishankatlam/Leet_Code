class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

       List<List<Integer>> res = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        int total = m*n;

         k%=total;

         int[][] ans = new int[m][n];

         for(int i=0;i<m;i++)
         {
            for(int j=0;j<n;j++)
            {
                int curr = i*n+j;
                int prev = (curr - k + total)%total;

                ans[i][j] = grid[prev/n][prev%n];

            }
         }

         for(int[] row : ans)
         {
            List<Integer> list = new ArrayList<>();
            for(int num : row)
            {
               list.add(num);
            }
            res.add(list);
         }
         return res ;
    }
}