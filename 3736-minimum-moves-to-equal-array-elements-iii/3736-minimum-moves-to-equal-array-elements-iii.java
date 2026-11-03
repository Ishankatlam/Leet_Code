class Solution {
    public int minMoves(int[] nums) {
        int ops=0;
        int max_num = Integer.MIN_VALUE;
        for(int num : nums){
            max_num = Math.max(max_num , num);
        }
        for(int num : nums){
            ops +=(max_num - num);
        }
        return ops ;

    }
}