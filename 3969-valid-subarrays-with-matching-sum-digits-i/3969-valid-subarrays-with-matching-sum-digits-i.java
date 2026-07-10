class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        
        int count  =0;

        for(int i=0;i<n;i++)
            {
                long currsum =0;

                for(int j=i;j<n;j++)
                    {
                        currsum += nums[j];

                        long abssum = Math.abs(currsum);

                        long lastdigit = abssum%10;

                        long firstdigit = abssum;

                        while(firstdigit >= 10)
                            {
                                firstdigit /=10;
                            }

                        if(firstdigit == x && lastdigit == x)
                        {
                            count ++;
                        }
                    }
            }
        return count ;
        
    }
}