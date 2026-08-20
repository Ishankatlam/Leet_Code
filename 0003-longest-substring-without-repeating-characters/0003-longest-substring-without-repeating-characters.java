class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left =0;
        int maxlength = 0;
        for(int right =0;right < s.length();right++)
        {
            char curr = s.charAt(right);
            while(set.contains(curr))
            {
              set.remove(Character.valueOf(s.charAt(left)));
              left++;
            }
            set.add(curr);
            maxlength = Math.max(maxlength , right - left +1 );
        }
        return maxlength;
    }
}