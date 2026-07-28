class Solution {
    public int maxDigitRange(int[] nums) {
       int maxRange = 0;
        for (int num : nums) {
            maxRange = Math.max(maxRange, getDigitRange(num));
        }

        int totalSum = 0;
        for (int num : nums) {
            if (getDigitRange(num) == maxRange) {
                totalSum += num;
            }
        }

        return totalSum;
    }
        private static int getDigitRange(int num) {
        num = Math.abs(num);
        int maxDigit = 0;
        int minDigit = 9;

        if (num == 0) return 0;

        while (num > 0) {
            int digit = num % 10;
            if (digit > maxDigit) maxDigit = digit;
            if (digit < minDigit) minDigit = digit;
            num /= 10;
        }

        return maxDigit - minDigit;
    }
}