class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        permuteHelper(0, nums, res);

        return new ArrayList<>(res);
    }
    public void permuteHelper(int i , int[] nums , Set<List<Integer>> res)
    {
        if(i==nums.length)
        {
            List<Integer> permutation = new ArrayList<>();
            for(int num : nums)permutation.add(num);
            res.add(permutation);
            return;
        }
        for(int j=i;j<nums.length;j++)
        {
            swaps(nums, i,j);
            permuteHelper(i+1, nums, res);
            swaps(nums, i,j);
        }
    }
    public void swaps(int[] nums, int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}