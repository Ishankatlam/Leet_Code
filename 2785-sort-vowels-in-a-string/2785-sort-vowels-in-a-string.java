class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        StringBuilder t = new StringBuilder();
        PriorityQueue<Character> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++)
        {
            if(isVowel(s.charAt(i)))
            {
                pq.add(s.charAt(i));
            }
        }
        for(int i=0;i<n;i++)
        {
            if(isVowel(s.charAt(i)))
            {
                char ch = pq.poll();
                t.append(ch);
            }
            else t.append(s.charAt(i));
        }
        return t.toString();
    }
    public boolean isVowel(char c)
    {
        return "aeiouAEIOU".indexOf(c)!=-1;
    }
}