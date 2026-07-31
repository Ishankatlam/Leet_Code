class Solution {
    public int pivotIndex(int[] nums) {
        int total =0 , pfx_sum =0;
        for(int ele : nums)
        {
            total += ele;
        }

        for(int p=0;p<nums.length;p++ )
        {
            int suf_sum = total - pfx_sum - nums[p];
            if(pfx_sum == suf_sum)return p;
            pfx_sum += nums[p];
        }
        return -1;
    }
}