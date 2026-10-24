class Solution {
    public int resilientSubarray(int[] nums, int k) {
        if(nums==null || nums.length == 0) return 0;
        int maxLen =0;
        int n = nums.length;
        int i=0;

        while(i<n)
        {
            int r = nums[i] % k;
            int j = i;

            while(j<n && (nums[j] % k)==r)
            {
                j++;
            }
            int totalSubLen = j-i;

            for(int count =1 ;count <=totalSubLen;count++)
            {
                if(((long)(count-1)*r)%k==0){
                    maxLen = Math.max(maxLen, count);
                }
            }
            i=j;
        }
        return maxLen;
    }
}