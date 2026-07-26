class Solution {
    public int maximumProduct(int[] nums) {
        if(nums.length==3)return nums[0]*nums[1]*nums[2];
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int first_min = Integer.MAX_VALUE;
        int sec_min = Integer.MAX_VALUE;


        for(int num : nums)
        {
            if(num > first){
                third = second ;
                second = first ;
                first = num;
            }
            else if(num>second)
            {
                 third = second;
                 second = num;
            }
            else if(num > third)
            {
                third = num;
            }

            if(num < first_min)
            {
                sec_min = first_min;
                first_min = num;
            }
            else if(num < sec_min)
            {
                sec_min = num;

            }
        }

        return Math.max(first * second * third  , first_min * sec_min * first);
    }
}