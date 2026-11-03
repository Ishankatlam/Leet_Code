class Solution {
    public int minMoves(int[] nums) {
      int total =0;
      int max = Integer.MIN_VALUE;
      for(int num : nums){
        total += num;
        if(num > max){
            max = num;
        }
      }
      return max*nums.length - total;
    }
}