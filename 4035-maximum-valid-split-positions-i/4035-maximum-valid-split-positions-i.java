class Solution {
    public int gcd(int a , int b)
    {
        while(b !=0)
        {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        int max_validSplits = 0;

        for(int j=-1;j<n;j++)
        {
            int m = (j==-1) ? n : n-1;
            if(m<2)continue;

            int[] arr = new int[n];
            int idx = 0;

            for(int k=0;k<n;k++)
            {
                if(k!=j){
                    arr[idx++] = nums[k];
                }
            }

            int[] pre = new int[m];
            pre[0] = arr[0];
            for(int i=1;i<m;i++)
            {
                pre[i] = gcd(pre[i-1] , arr[i]);
            }

            int[] suff = new int[m];
            suff[m-1] = arr[m-1];
            for(int i=m-2;i>=0;i--)
            {
                suff[i] = gcd(suff[i+1] , arr[i]);
            }

            int currScore = 0;
            for(int i=0;i<m-1;i++)
            {
                if(pre[i] == suff[i+1])
                {
                    currScore++; 
                }
            }
            max_validSplits = Math.max(max_validSplits , currScore );
        }
        return max_validSplits;
    }
}