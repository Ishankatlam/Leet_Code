class Solution {
    public long getSum(int[] nums) {
       int n = nums.length;

        long[] prefix = new long[n + 1];

        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
            ans = Math.max(ans, nums[i]);
        }

        
        int[] d1 = new int[n];

        int l = 0;
        int r = -1;

        for (int i = 0; i < n; i++) {

            int k = (i > r) ? 1 : Math.min(d1[l + r - i], r - i + 1);

            while (i - k >= 0 &&
                    i + k < n &&
                    nums[i - k] == nums[i + k]) {
                k++;
            }

            d1[i] = k;

            if (i + k - 1 > r) {
                l = i - k + 1;
                r = i + k - 1;
            }
        }

    
        int[] d2 = new int[n];

        l = 0;
        r = -1;

        for (int i = 0; i < n; i++) {

            int k = (i > r) ? 0 : Math.min(d2[l + r - i + 1], r - i + 1);

            while (i - k - 1 >= 0 &&
                    i + k < n &&
                    nums[i - k - 1] == nums[i + k]) {
                k++;
            }

            d2[i] = k;

            if (i + k - 1 > r) {
                l = i - k;
                r = i + k - 1;
            }
        }


        for (int i = 0; i < n; i++) {

            // odd
            int left = i - d1[i] + 1;
            int right = i + d1[i] - 1;

            ans = Math.max(ans,
                    prefix[right + 1] - prefix[left]);

            

            if (d2[i] > 0) {

                left = i - d2[i];
                right = i + d2[i] - 1;

                ans = Math.max(ans,
                        prefix[right + 1] - prefix[left]);
            }
        }

        return ans;
    }
}