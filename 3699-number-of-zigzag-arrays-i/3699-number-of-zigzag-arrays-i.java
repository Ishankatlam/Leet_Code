class Solution {
    public int zigZagArrays(int n, int l, int r) {
        long Mod = 1000000007;
        int m = r-l+1;

        long[] up = new long[m+1];
        long[] down = new long[m+1];

        for(int v=1;v<=m;v++)
        {
            up[v] = v-1;
            down[v] = m-v;
        }

        for(int len =3 ;len<=n;len++)
        {
            long[] prefixUp = new long[m+1];
            long[] prefixDown = new long[m+1];

            for(int i=1;i<=m;i++)
            {
                prefixUp[i] = (prefixUp[i-1] + up[i]) % Mod;
                prefixDown[i] = (prefixDown[i-1] + down[i])%Mod;
            } 

            long totalUp = prefixUp[m];

            long[] newUp = new long[m+1];
            long[] newDown = new long[m+1];

            for(int j=1;j<=m;j++)
            {
                newUp[j] = prefixDown[j-1];
                newDown[j] =(totalUp - prefixUp[j] + Mod) % Mod;
            }
            up = newUp;
            down = newDown;
        }
        long ans =0;
        if(n==2)
        {
            for(int v=1;v<=m;v++)
            {
                ans = (ans + up[v] + down[v])%Mod;
            }
            return (int) ans ;
        }
                    for(int v=1;v<=m;v++)
            {
                ans = (ans + up[v] + down[v])%Mod;
            }
            return (int) ans ;
    }
}