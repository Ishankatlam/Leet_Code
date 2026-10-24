class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int n = nums.length;
      int maxProduct = Integer.MIN_VALUE;
        int[] ans = new int[]{-1,-1};

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int complement = target - nums[i];
            if(map.containsKey(complement))
            {
                int j = map.get(complement);

                int idxi = nums[i] > complement ? i : j;
                int idxj = nums[i] > complement ? j : i;
                
                if(nums[idxi] > nums[idxj]){
                    int currentProduct = nums[idxi] * nums[idxj];

                    if(currentProduct > maxProduct)
                    {
                        maxProduct = currentProduct;
                        ans[0] = idxi;
                        ans[1] = idxj; 
                    }
                }
            }

            map.put(nums[i],i);
        }
        return ans ;
    }
}