class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        long sum =0;
        HashMap<Long , Integer> map = new HashMap<>();
        int res =0;

        for(int i=0;i<nums.length;i++)
        {
            sum =((sum + nums[i])%k + k )%k;
            if(sum ==0)res=i+1;

            else if(map.containsKey(sum))
            {
                res = Math.max(res , i- map.get(sum));
            }
            else map.put(sum , i );
        }
        return (res >= 2)? true : false ;
    }
}