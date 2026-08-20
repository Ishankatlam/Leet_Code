class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        Integer f_m = null, s_m= null , t_m= null ;
       for (int num : nums) {
            if ((f_m != null && f_m == num) || 
                (s_m != null && s_m == num) || 
                (t_m != null && t_m == num)) {
                continue;
            }
            
            if (f_m == null || num > f_m) {
                t_m = s_m; 
                s_m = f_m; 
                f_m = num; 
            } else if (s_m == null || num > s_m) {
                t_m = s_m; 
                s_m = num; 
            } else if (t_m == null || num > t_m) {
                t_m = num; 
            }
        }

        return (t_m==null) ? f_m : t_m;
        
    }
}