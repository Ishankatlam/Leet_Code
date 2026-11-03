class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int ops=0;
        int max_num = Arrays.stream(nums)
                     .parallel()
                     .max()
                     .getAsInt();
        for(int num : nums){
            ops +=(max_num - num);
        }
        return ops ;

    }
}